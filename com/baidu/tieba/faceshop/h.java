package com.baidu.tieba.faceshop;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class h extends ProxyAdkBaseActivity<h> {
    private TextView gfU;
    private List<c> iTn;
    private d iTp;
    private a iTq;
    private LinearLayout iTr;
    private NavigationBar iTs;
    private TextView iTt;
    private TextView iTu;
    private ImageView iTv;
    private BdListView iTw;
    private TextView iTx;
    private View iTy;
    private b iTz;
    private View mBack;
    private final List<String> iTo = new LinkedList();
    private boolean iTA = false;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.iTt) {
                h.this.cyx();
            } else if (view == h.this.gfU) {
                if (h.this.iTA) {
                    h.this.cyv();
                    h.this.iTo.clear();
                } else {
                    h.this.cyu();
                }
                h.this.iTz.notifyDataSetChanged();
            } else if (view == h.this.iTx) {
                IntentConfig intentConfig = new IntentConfig(h.this.getActivity());
                intentConfig.getIntent().putExtra("emotion_manage", "emotion_manage");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPURCHASERECORDS, intentConfig));
                h.this.cyv();
                h.this.qg(true);
            }
        }
    };
    private final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.faceshop.h.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            e eVar;
            if (h.this.iTA) {
                if (h.this.iTn.get(i) != null && (eVar = (e) view.getTag()) != null) {
                    Object tag = eVar.iTE.getTag();
                    if (tag instanceof String) {
                        String str = (String) tag;
                        for (c cVar : h.this.iTn) {
                            if (cVar.id.equals(str)) {
                                if (h.this.iTo.contains(str)) {
                                    ap.setImageResource(eVar.iTE, R.drawable.btn_expression_choose_n);
                                    h.this.iTo.remove(str);
                                    h.this.JA(str);
                                    cVar.iTC = false;
                                } else {
                                    ap.setImageResource(eVar.iTE, R.drawable.btn_expression_choose_s);
                                    h.this.Jz(str);
                                    cVar.iTC = true;
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            h.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(h.this.getPageContext().getPageActivity(), ((c) h.this.iTn.get(i)).id, false, "emotion_manage")));
        }
    };
    private final CustomMessageListener eJz = new CustomMessageListener(0) { // from class: com.baidu.tieba.faceshop.h.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001117) {
                h.this.iTp = new d();
                h.this.iTp.execute(new String[0]);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_emotion_manage);
        initView();
        initData();
        qg(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.iTq != null) {
            this.iTq.cancel(true);
            this.iTq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iTs.onChangeSkinType(getPageContext(), i);
        ap.setBackgroundResource(this.iTt, R.drawable.btn_delete_groupupdates);
    }

    private void initView() {
        this.iTr = (LinearLayout) findViewById(R.id.emotion_manage_root);
        this.iTs = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.iTs.setTitleText(R.string.title_activity_emotion_manage);
        this.mBack = this.iTs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iTt = this.iTs.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.delete) + "(" + this.iTo.size() + ")", this.mOnClickListener, true);
        cyw();
        this.gfU = this.iTs.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.edit), this.mOnClickListener);
        ap.setViewTextColor(this.gfU, R.color.CAM_X0106, 1);
        this.iTu = (TextView) findViewById(R.id.emotion_manager_title);
        this.iTv = (ImageView) findViewById(R.id.emotion_manage_enter_line_list_up);
        this.iTw = (BdListView) findViewById(R.id.emotion_manage_list);
        this.iTw.setOnItemClickListener(this.mOnItemClickListener);
        this.iTy = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.emotion_manage_list_footer, (ViewGroup) null);
        this.iTw.addFooterView(this.iTy);
        this.iTx = (TextView) this.iTy.findViewById(R.id.emotion_manage_enter_record);
        this.iTx.setOnClickListener(this.mOnClickListener);
        getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        getLayoutMode().onModeChanged(this.iTr);
        getLayoutMode().onModeChanged(this.iTy);
        cyv();
    }

    private void initData() {
        registerListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED, this.eJz);
        this.iTp = new d();
        this.iTp.execute(new String[0]);
        this.iTz = new b();
        this.iTw.setAdapter((ListAdapter) this.iTz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(boolean z) {
        boolean z2;
        if (z) {
            this.iTo.clear();
        } else {
            for (String str : this.iTo) {
                Iterator<c> it = this.iTn.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    } else if (str.equals(it.next().id)) {
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.iTo.remove(str);
                }
            }
        }
        cyw();
        cyt();
        this.iTz.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyt() {
        if (this.iTn != null) {
            if (this.iTn.size() == 0) {
                this.iTu.setText(R.string.emotion_manage_title_nodata);
                this.gfU.setEnabled(false);
                this.iTv.setVisibility(8);
                cyv();
                return;
            }
            this.iTu.setText(R.string.emotion_manage_title);
            this.gfU.setEnabled(true);
            this.iTv.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jz(String str) {
        if (!this.iTo.contains(str)) {
            this.iTo.add(str);
            cyw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JA(String str) {
        this.iTo.remove(str);
        cyw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyu() {
        this.mBack.setVisibility(8);
        this.iTt.setVisibility(0);
        cyw();
        this.gfU.setText(getString(R.string.cancel));
        this.iTA = true;
        this.iTy.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyv() {
        this.mBack.setVisibility(0);
        this.iTt.setVisibility(8);
        this.gfU.setText(getString(R.string.edit));
        this.iTA = false;
        this.iTy.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    private void cyw() {
        int size = this.iTo.size();
        this.iTt.setText(getString(R.string.delete) + "(" + size + ")");
        if (size == 0) {
            this.iTt.setEnabled(false);
        } else {
            this.iTt.setEnabled(true);
        }
        ap.setBackgroundResource(this.iTt, R.drawable.btn_delete_groupupdates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyx() {
        this.iTq = new a();
        this.iTq.execute(this.iTo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends BaseAdapter {
        private b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (h.this.iTn != null) {
                return h.this.iTn.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (h.this.iTn != null && i <= h.this.iTn.size()) {
                return h.this.iTn.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (h.this.iTn == null || i > h.this.iTn.size()) {
                return 0L;
            }
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = createView();
            }
            e eVar = (e) view.getTag();
            Bitmap bitmap = ((c) h.this.iTn.get(i)).iTD;
            if (bitmap != null) {
                eVar.iTF.setImageBitmap(bitmap);
            } else {
                ap.setImageResource(eVar.iTF, R.drawable.pic_image_h_not);
            }
            if (h.this.iTA) {
                if (h.this.iTo.contains(((c) h.this.iTn.get(i)).id)) {
                    ap.setImageResource(eVar.iTE, R.drawable.btn_expression_choose_s);
                } else {
                    ap.setImageResource(eVar.iTE, R.drawable.btn_expression_choose_n);
                }
                eVar.iTE.setVisibility(0);
                eVar.iTE.setTag(((c) h.this.iTn.get(i)).id);
            } else {
                eVar.iTE.setVisibility(8);
            }
            eVar.enq.setText(((c) h.this.iTn.get(i)).name);
            h.this.getLayoutMode().onModeChanged(view);
            return view;
        }

        private View createView() {
            View inflate = View.inflate(h.this.getPageContext().getPageActivity(), R.layout.emotion_manage_list_item, null);
            e eVar = new e();
            eVar.iTE = (ImageView) inflate.findViewById(R.id.emotion_group_select);
            eVar.iTF = (ImageView) inflate.findViewById(R.id.emotion_group_photo);
            eVar.enq = (TextView) inflate.findViewById(R.id.emotion_group_name);
            inflate.setTag(eVar);
            return inflate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c {
        boolean iTC;
        Bitmap iTD;
        String id;
        String name;

        private c() {
            this.iTC = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class d extends BdAsyncTask<String, Integer, List<c>> {
        private d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: R */
        public List<c> doInBackground(String... strArr) {
            List<MyEmotionGroupData> Jw = com.baidu.tieba.faceshop.a.cyo().Jw(TbadkApplication.getCurrentAccount());
            List<EmotionGroupData> xY = i.cyE().xY(1);
            LinkedList linkedList = new LinkedList();
            for (MyEmotionGroupData myEmotionGroupData : Jw) {
                Iterator<EmotionGroupData> it = xY.iterator();
                while (true) {
                    if (it.hasNext()) {
                        EmotionGroupData next = it.next();
                        if (myEmotionGroupData.getGroupId().equals(next.getGroupId()) && com.baidu.tieba.faceshop.b.Jx(next.getGroupId())) {
                            c cVar = new c();
                            cVar.id = next.getGroupId();
                            cVar.name = next.getGroupName();
                            cVar.iTD = com.baidu.tieba.faceshop.b.eQ(cVar.id, "list.png");
                            linkedList.add(cVar);
                            break;
                        }
                    }
                }
            }
            Jw.clear();
            xY.clear();
            return linkedList;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            h.this.showProgressBar();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public void onPostExecute(List<c> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            h.this.iTn = list;
            h.this.qg(false);
            h.this.hideProgressBar();
            h.this.cyt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends BdAsyncTask<List<String>, Integer, Boolean> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public Boolean doInBackground(List<String>... listArr) {
            List<String> list = listArr[0];
            if (list == null || list.isEmpty()) {
                return false;
            }
            int i = 0;
            for (String str : list) {
                MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
                myEmotionGroupData.setGroupId(str);
                myEmotionGroupData.setUid(TbadkApplication.getCurrentAccount());
                i = com.baidu.tieba.faceshop.a.cyo().a(myEmotionGroupData) ? i + 1 : i;
            }
            if (i > 0) {
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            if (bool.booleanValue()) {
                MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_RELOAD_EMOTION_GROUPS, (Class) null);
                h.this.iTA = true;
                h.this.qg(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class e {
        TextView enq;
        ImageView iTE;
        ImageView iTF;

        private e() {
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onBackPressed() {
        if (this.iTA) {
            cyv();
            this.iTo.clear();
            this.iTA = false;
            this.iTz.notifyDataSetChanged();
            return;
        }
        super.onBackPressed();
    }
}
