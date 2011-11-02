package com.baidu.tieba.home;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.tieba.R;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.model.MarklistModel;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MarkView {
    private static final int MENU_ID_DEL = 1;
    private static final int MENU_ID_ENTER = 0;
    private HomeActivity mActivity;
    private ImageButton mButtonLike = null;
    private ListView mListMark = null;
    private MarkAdapter mAdapterMark = null;
    private HomeMarkAsyncTask mMarkTask = null;
    private MarklistModel mModelMarks = null;
    private MarkData mMarkData = null;
    private int mClickItem = -1;
    AlertDialog mMenuMark = null;
    private DialogInterface.OnClickListener mDialogMenuListener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.home.MarkView.1
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int item) {
            switch (item) {
                case 0:
                    if (MarkView.this.mMarkData != null) {
                        PbActivity.startAcitivity(MarkView.this.mActivity, MarkView.this.mMarkData);
                        return;
                    }
                    return;
                case 1:
                    MarkView.this.execDel();
                    return;
                default:
                    return;
            }
        }
    };

    public MarkView(Activity m) {
        this.mActivity = null;
        this.mActivity = (HomeActivity) m;
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

    public void init() {
        this.mButtonLike = (ImageButton) this.mActivity.findViewById(R.id.home_bt_like);
        this.mButtonLike.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.MarkView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MarkView.this.mActivity.goToLike(false);
            }
        });
        this.mListMark = (ListView) this.mActivity.findViewById(R.id.home_lv_mark);
        this.mAdapterMark = new MarkAdapter(this.mActivity, null);
        this.mListMark.setAdapter((ListAdapter) this.mAdapterMark);
        this.mListMark.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.home.MarkView.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ListView tmpList = (ListView) arg0;
                MarkView.this.mMarkData = (MarkData) tmpList.getAdapter().getItem(arg2);
                if (MarkView.this.mMarkData != null) {
                    PbActivity.startAcitivity(MarkView.this.mActivity, MarkView.this.mMarkData);
                }
            }
        });
        this.mListMark.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.home.MarkView.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ListView tmpList = (ListView) arg0;
                MarkView.this.mMarkData = (MarkData) tmpList.getAdapter().getItem(arg2);
                MarkView.this.mClickItem = arg2;
                MarkView.this.mMenuMark.show();
                return true;
            }
        });
        CharSequence[] itemsMark = {this.mActivity.getString(R.string.enter), this.mActivity.getString(R.string.delete_mark)};
        AlertDialog.Builder builderMark = new AlertDialog.Builder(this.mActivity);
        builderMark.setTitle(this.mActivity.getString(R.string.operation));
        builderMark.setItems(itemsMark, this.mDialogMenuListener);
        this.mMenuMark = builderMark.create();
        this.mMenuMark.setCanceledOnTouchOutside(true);
    }

    public void exec(boolean isRefresh) {
        this.mActivity.setVisibility(8, 0);
        this.mActivity.setHomeType(2);
        if (this.mModelMarks == null || DatabaseService.getMarkState().booleanValue()) {
            cancelAsyncTask();
            this.mMarkTask = new HomeMarkAsyncTask();
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
                this.mActivity.showToast(this.mActivity.getString(R.string.success));
                return;
            }
            this.mActivity.showToast(this.mActivity.getString(R.string.fail));
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
            if (data == null) {
                MarkView.this.mActivity.showToast("");
            } else {
                MarkView.this.mModelMarks = data;
                MarkView.this.refreshMark();
                System.gc();
            }
            MarkView.this.mMarkTask = null;
        }

        public void cancel() {
            super.cancel(true);
        }
    }
}
