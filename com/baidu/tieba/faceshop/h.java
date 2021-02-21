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
    private TextView gfZ;
    private List<c> iTB;
    private d iTD;
    private a iTE;
    private LinearLayout iTF;
    private NavigationBar iTG;
    private TextView iTH;
    private TextView iTI;
    private ImageView iTJ;
    private BdListView iTK;
    private TextView iTL;
    private View iTM;
    private b iTN;
    private View mBack;
    private final List<String> iTC = new LinkedList();
    private boolean iTO = false;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.iTH) {
                h.this.cyE();
            } else if (view == h.this.gfZ) {
                if (h.this.iTO) {
                    h.this.cyC();
                    h.this.iTC.clear();
                } else {
                    h.this.cyB();
                }
                h.this.iTN.notifyDataSetChanged();
            } else if (view == h.this.iTL) {
                IntentConfig intentConfig = new IntentConfig(h.this.getActivity());
                intentConfig.getIntent().putExtra("emotion_manage", "emotion_manage");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPURCHASERECORDS, intentConfig));
                h.this.cyC();
                h.this.qg(true);
            }
        }
    };
    private final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.faceshop.h.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            e eVar;
            if (h.this.iTO) {
                if (h.this.iTB.get(i) != null && (eVar = (e) view.getTag()) != null) {
                    Object tag = eVar.iTS.getTag();
                    if (tag instanceof String) {
                        String str = (String) tag;
                        for (c cVar : h.this.iTB) {
                            if (cVar.id.equals(str)) {
                                if (h.this.iTC.contains(str)) {
                                    ap.setImageResource(eVar.iTS, R.drawable.btn_expression_choose_n);
                                    h.this.iTC.remove(str);
                                    h.this.JB(str);
                                    cVar.iTQ = false;
                                } else {
                                    ap.setImageResource(eVar.iTS, R.drawable.btn_expression_choose_s);
                                    h.this.JA(str);
                                    cVar.iTQ = true;
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            h.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(h.this.getPageContext().getPageActivity(), ((c) h.this.iTB.get(i)).id, false, "emotion_manage")));
        }
    };
    private final CustomMessageListener eJz = new CustomMessageListener(0) { // from class: com.baidu.tieba.faceshop.h.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001117) {
                h.this.iTD = new d();
                h.this.iTD.execute(new String[0]);
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
        if (this.iTE != null) {
            this.iTE.cancel(true);
            this.iTE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iTG.onChangeSkinType(getPageContext(), i);
        ap.setBackgroundResource(this.iTH, R.drawable.btn_delete_groupupdates);
    }

    private void initView() {
        this.iTF = (LinearLayout) findViewById(R.id.emotion_manage_root);
        this.iTG = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.iTG.setTitleText(R.string.title_activity_emotion_manage);
        this.mBack = this.iTG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iTH = this.iTG.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.delete) + "(" + this.iTC.size() + ")", this.mOnClickListener, true);
        cyD();
        this.gfZ = this.iTG.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.edit), this.mOnClickListener);
        ap.setViewTextColor(this.gfZ, R.color.CAM_X0106, 1);
        this.iTI = (TextView) findViewById(R.id.emotion_manager_title);
        this.iTJ = (ImageView) findViewById(R.id.emotion_manage_enter_line_list_up);
        this.iTK = (BdListView) findViewById(R.id.emotion_manage_list);
        this.iTK.setOnItemClickListener(this.mOnItemClickListener);
        this.iTM = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.emotion_manage_list_footer, (ViewGroup) null);
        this.iTK.addFooterView(this.iTM);
        this.iTL = (TextView) this.iTM.findViewById(R.id.emotion_manage_enter_record);
        this.iTL.setOnClickListener(this.mOnClickListener);
        getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        getLayoutMode().onModeChanged(this.iTF);
        getLayoutMode().onModeChanged(this.iTM);
        cyC();
    }

    private void initData() {
        registerListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED, this.eJz);
        this.iTD = new d();
        this.iTD.execute(new String[0]);
        this.iTN = new b();
        this.iTK.setAdapter((ListAdapter) this.iTN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(boolean z) {
        boolean z2;
        if (z) {
            this.iTC.clear();
        } else {
            for (String str : this.iTC) {
                Iterator<c> it = this.iTB.iterator();
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
                    this.iTC.remove(str);
                }
            }
        }
        cyD();
        cyA();
        this.iTN.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyA() {
        if (this.iTB != null) {
            if (this.iTB.size() == 0) {
                this.iTI.setText(R.string.emotion_manage_title_nodata);
                this.gfZ.setEnabled(false);
                this.iTJ.setVisibility(8);
                cyC();
                return;
            }
            this.iTI.setText(R.string.emotion_manage_title);
            this.gfZ.setEnabled(true);
            this.iTJ.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JA(String str) {
        if (!this.iTC.contains(str)) {
            this.iTC.add(str);
            cyD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JB(String str) {
        this.iTC.remove(str);
        cyD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyB() {
        this.mBack.setVisibility(8);
        this.iTH.setVisibility(0);
        cyD();
        this.gfZ.setText(getString(R.string.cancel));
        this.iTO = true;
        this.iTM.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyC() {
        this.mBack.setVisibility(0);
        this.iTH.setVisibility(8);
        this.gfZ.setText(getString(R.string.edit));
        this.iTO = false;
        this.iTM.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    private void cyD() {
        int size = this.iTC.size();
        this.iTH.setText(getString(R.string.delete) + "(" + size + ")");
        if (size == 0) {
            this.iTH.setEnabled(false);
        } else {
            this.iTH.setEnabled(true);
        }
        ap.setBackgroundResource(this.iTH, R.drawable.btn_delete_groupupdates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyE() {
        this.iTE = new a();
        this.iTE.execute(this.iTC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends BaseAdapter {
        private b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (h.this.iTB != null) {
                return h.this.iTB.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (h.this.iTB != null && i <= h.this.iTB.size()) {
                return h.this.iTB.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (h.this.iTB == null || i > h.this.iTB.size()) {
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
            Bitmap bitmap = ((c) h.this.iTB.get(i)).iTR;
            if (bitmap != null) {
                eVar.iTT.setImageBitmap(bitmap);
            } else {
                ap.setImageResource(eVar.iTT, R.drawable.pic_image_h_not);
            }
            if (h.this.iTO) {
                if (h.this.iTC.contains(((c) h.this.iTB.get(i)).id)) {
                    ap.setImageResource(eVar.iTS, R.drawable.btn_expression_choose_s);
                } else {
                    ap.setImageResource(eVar.iTS, R.drawable.btn_expression_choose_n);
                }
                eVar.iTS.setVisibility(0);
                eVar.iTS.setTag(((c) h.this.iTB.get(i)).id);
            } else {
                eVar.iTS.setVisibility(8);
            }
            eVar.enq.setText(((c) h.this.iTB.get(i)).name);
            h.this.getLayoutMode().onModeChanged(view);
            return view;
        }

        private View createView() {
            View inflate = View.inflate(h.this.getPageContext().getPageActivity(), R.layout.emotion_manage_list_item, null);
            e eVar = new e();
            eVar.iTS = (ImageView) inflate.findViewById(R.id.emotion_group_select);
            eVar.iTT = (ImageView) inflate.findViewById(R.id.emotion_group_photo);
            eVar.enq = (TextView) inflate.findViewById(R.id.emotion_group_name);
            inflate.setTag(eVar);
            return inflate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c {
        boolean iTQ;
        Bitmap iTR;
        String id;
        String name;

        private c() {
            this.iTQ = false;
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
            List<MyEmotionGroupData> Jx = com.baidu.tieba.faceshop.a.cyv().Jx(TbadkApplication.getCurrentAccount());
            List<EmotionGroupData> xY = i.cyL().xY(1);
            LinkedList linkedList = new LinkedList();
            for (MyEmotionGroupData myEmotionGroupData : Jx) {
                Iterator<EmotionGroupData> it = xY.iterator();
                while (true) {
                    if (it.hasNext()) {
                        EmotionGroupData next = it.next();
                        if (myEmotionGroupData.getGroupId().equals(next.getGroupId()) && com.baidu.tieba.faceshop.b.Jy(next.getGroupId())) {
                            c cVar = new c();
                            cVar.id = next.getGroupId();
                            cVar.name = next.getGroupName();
                            cVar.iTR = com.baidu.tieba.faceshop.b.eQ(cVar.id, "list.png");
                            linkedList.add(cVar);
                            break;
                        }
                    }
                }
            }
            Jx.clear();
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
            h.this.iTB = list;
            h.this.qg(false);
            h.this.hideProgressBar();
            h.this.cyA();
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
                i = com.baidu.tieba.faceshop.a.cyv().a(myEmotionGroupData) ? i + 1 : i;
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
                h.this.iTO = true;
                h.this.qg(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class e {
        TextView enq;
        ImageView iTS;
        ImageView iTT;

        private e() {
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onBackPressed() {
        if (this.iTO) {
            cyC();
            this.iTC.clear();
            this.iTO = false;
            this.iTN.notifyDataSetChanged();
            return;
        }
        super.onBackPressed();
    }
}
