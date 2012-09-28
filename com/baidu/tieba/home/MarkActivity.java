package com.baidu.tieba.home;

import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.model.MarklistModel;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MarkActivity extends BaseActivity {
    private static final int MENU_ID_DEL = 1;
    private static final int MENU_ID_ENTER = 0;
    private ListView mListMark = null;
    private MarkAdapter mAdapterMark = null;
    private HomeMarkAsyncTask mMarkTask = null;
    private MarklistModel mModelMarks = null;
    private MarkData mMarkData = null;
    private int mClickItem = -1;
    AlertDialog mMenuMark = null;
    private DialogInterface.OnClickListener mDialogMenuListener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.home.MarkActivity.1
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int item) {
            switch (item) {
                case 0:
                    if (MarkActivity.this.mMarkData == null) {
                        return;
                    }
                    MarkActivity.this.enter();
                    return;
                case 1:
                    MarkActivity.this.execDel();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mark_activity);
        init();
    }

    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        exec(false);
    }

    public void cancelAsyncTask() {
        if (this.mMarkTask != null) {
            this.mMarkTask.cancel();
            this.mMarkTask = null;
        }
    }

    public void closeDialog() {
        if (this.mMenuMark != null) {
            this.mMenuMark.dismiss();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return getParent() instanceof ActivityGroup ? getParent().onSearchRequested() : super.onSearchRequested();
    }

    private void init() {
        this.mListMark = (ListView) findViewById(R.id.home_lv_mark);
        this.mAdapterMark = new MarkAdapter(this, null);
        this.mListMark.setAdapter((ListAdapter) this.mAdapterMark);
        this.mListMark.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.home.MarkActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ListView tmpList = (ListView) arg0;
                MarkActivity.this.mMarkData = (MarkData) tmpList.getAdapter().getItem(arg2);
                if (MarkActivity.this.mMarkData == null) {
                    return;
                }
                MarkActivity.this.enter();
            }
        });
        this.mListMark.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.home.MarkActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                TiebaLog.e("------------", "::", event.toString());
                return false;
            }
        });
        this.mListMark.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.home.MarkActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ListView tmpList = (ListView) arg0;
                MarkActivity.this.mMarkData = (MarkData) tmpList.getAdapter().getItem(arg2);
                MarkActivity.this.mClickItem = arg2;
                MarkActivity.this.mMenuMark.show();
                return true;
            }
        });
        CharSequence[] itemsMark = {getString(R.string.enter), getString(R.string.delete_mark)};
        AlertDialog.Builder builderMark = new AlertDialog.Builder(getParent());
        builderMark.setTitle(getString(R.string.operation));
        builderMark.setItems(itemsMark, this.mDialogMenuListener);
        this.mMenuMark = builderMark.create();
        this.mMenuMark.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enter() {
        if (this.mMarkData != null) {
            PbActivity.startAcitivity(this, this.mMarkData);
        }
    }

    public void exec(boolean isRefresh) {
        if (this.mModelMarks == null || DatabaseService.getMarkState().booleanValue()) {
            cancelAsyncTask();
            this.mMarkTask = new HomeMarkAsyncTask(this, null);
            this.mMarkTask.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execDel() {
        if (this.mMarkData != null) {
            DatabaseService.deleteMarkData(this.mMarkData.getId());
            this.mAdapterMark.notifyDataSetChanged();
        }
        ArrayList<MarkData> datas = this.mAdapterMark.getData();
        if (datas != null && this.mClickItem >= 0 && this.mClickItem < datas.size()) {
            boolean ret = DatabaseService.deleteMarkData(datas.get(this.mClickItem).getId());
            if (ret) {
                datas.remove(this.mClickItem);
                this.mAdapterMark.checkNodata();
                this.mAdapterMark.notifyDataSetChanged();
                showToast(getString(R.string.success));
                return;
            }
            showToast(getString(R.string.fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshMark() {
        ArrayList<MarkData> list;
        try {
            if (this.mModelMarks != null && (list = this.mModelMarks.getMark_list()) != null) {
                this.mAdapterMark.setData(list);
                this.mAdapterMark.notifyDataSetInvalidated();
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "", "HomeActivity.refreshLike error = " + ex.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class HomeMarkAsyncTask extends AsyncTask<Object, Integer, MarklistModel> {
        private HomeMarkAsyncTask() {
        }

        /* synthetic */ HomeMarkAsyncTask(MarkActivity markActivity, HomeMarkAsyncTask homeMarkAsyncTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public MarklistModel doInBackground(Object... params) {
            MarklistModel marklistData = new MarklistModel();
            try {
                marklistData.doDB();
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "", "PbAsyncTask.doInBackground error = " + ex.getMessage());
            }
            return marklistData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(MarklistModel data) {
            if (data != null) {
                MarkActivity.this.mModelMarks = data;
                MarkActivity.this.refreshMark();
                System.gc();
            } else {
                MarkActivity.this.showToast("");
            }
            MarkActivity.this.mMarkTask = null;
        }

        public void cancel() {
            super.cancel(true);
        }
    }
}
