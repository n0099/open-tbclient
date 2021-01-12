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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class h extends ProxyAdkBaseActivity<h> {
    private TextView gdF;
    private List<c> iNG;
    private d iNI;
    private a iNJ;
    private LinearLayout iNK;
    private NavigationBar iNL;
    private TextView iNM;
    private TextView iNN;
    private ImageView iNO;
    private BdListView iNP;
    private TextView iNQ;
    private View iNR;
    private b iNS;
    private View mBack;
    private final List<String> iNH = new LinkedList();
    private boolean iNT = false;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.iNM) {
                h.this.cxm();
            } else if (view == h.this.gdF) {
                if (h.this.iNT) {
                    h.this.cxk();
                    h.this.iNH.clear();
                } else {
                    h.this.cxj();
                }
                h.this.iNS.notifyDataSetChanged();
            } else if (view == h.this.iNQ) {
                IntentConfig intentConfig = new IntentConfig(h.this.getActivity());
                intentConfig.getIntent().putExtra("emotion_manage", "emotion_manage");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPURCHASERECORDS, intentConfig));
                h.this.cxk();
                h.this.pW(true);
            }
        }
    };
    private final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.faceshop.h.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            e eVar;
            if (h.this.iNT) {
                if (h.this.iNG.get(i) != null && (eVar = (e) view.getTag()) != null) {
                    Object tag = eVar.iNX.getTag();
                    if (tag instanceof String) {
                        String str = (String) tag;
                        for (c cVar : h.this.iNG) {
                            if (cVar.id.equals(str)) {
                                if (h.this.iNH.contains(str)) {
                                    ao.setImageResource(eVar.iNX, R.drawable.btn_expression_choose_n);
                                    h.this.iNH.remove(str);
                                    h.this.IP(str);
                                    cVar.iNV = false;
                                } else {
                                    ao.setImageResource(eVar.iNX, R.drawable.btn_expression_choose_s);
                                    h.this.IO(str);
                                    cVar.iNV = true;
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            h.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(h.this.getPageContext().getPageActivity(), ((c) h.this.iNG.get(i)).id, false, "emotion_manage")));
        }
    };
    private final CustomMessageListener eHt = new CustomMessageListener(0) { // from class: com.baidu.tieba.faceshop.h.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001117) {
                h.this.iNI = new d();
                h.this.iNI.execute(new String[0]);
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
        pW(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.iNJ != null) {
            this.iNJ.cancel(true);
            this.iNJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iNL.onChangeSkinType(getPageContext(), i);
        ao.setBackgroundResource(this.iNM, R.drawable.btn_delete_groupupdates);
    }

    private void initView() {
        this.iNK = (LinearLayout) findViewById(R.id.emotion_manage_root);
        this.iNL = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.iNL.setTitleText(R.string.title_activity_emotion_manage);
        this.mBack = this.iNL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iNM = this.iNL.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.delete) + "(" + this.iNH.size() + ")", this.mOnClickListener, true);
        cxl();
        this.gdF = this.iNL.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.edit), this.mOnClickListener);
        ao.setViewTextColor(this.gdF, R.color.CAM_X0106, 1);
        this.iNN = (TextView) findViewById(R.id.emotion_manager_title);
        this.iNO = (ImageView) findViewById(R.id.emotion_manage_enter_line_list_up);
        this.iNP = (BdListView) findViewById(R.id.emotion_manage_list);
        this.iNP.setOnItemClickListener(this.mOnItemClickListener);
        this.iNR = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.emotion_manage_list_footer, (ViewGroup) null);
        this.iNP.addFooterView(this.iNR);
        this.iNQ = (TextView) this.iNR.findViewById(R.id.emotion_manage_enter_record);
        this.iNQ.setOnClickListener(this.mOnClickListener);
        getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        getLayoutMode().onModeChanged(this.iNK);
        getLayoutMode().onModeChanged(this.iNR);
        cxk();
    }

    private void initData() {
        registerListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED, this.eHt);
        this.iNI = new d();
        this.iNI.execute(new String[0]);
        this.iNS = new b();
        this.iNP.setAdapter((ListAdapter) this.iNS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pW(boolean z) {
        boolean z2;
        if (z) {
            this.iNH.clear();
        } else {
            for (String str : this.iNH) {
                Iterator<c> it = this.iNG.iterator();
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
                    this.iNH.remove(str);
                }
            }
        }
        cxl();
        cxi();
        this.iNS.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxi() {
        if (this.iNG != null) {
            if (this.iNG.size() == 0) {
                this.iNN.setText(R.string.emotion_manage_title_nodata);
                this.gdF.setEnabled(false);
                this.iNO.setVisibility(8);
                cxk();
                return;
            }
            this.iNN.setText(R.string.emotion_manage_title);
            this.gdF.setEnabled(true);
            this.iNO.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IO(String str) {
        if (!this.iNH.contains(str)) {
            this.iNH.add(str);
            cxl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IP(String str) {
        this.iNH.remove(str);
        cxl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxj() {
        this.mBack.setVisibility(8);
        this.iNM.setVisibility(0);
        cxl();
        this.gdF.setText(getString(R.string.cancel));
        this.iNT = true;
        this.iNR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxk() {
        this.mBack.setVisibility(0);
        this.iNM.setVisibility(8);
        this.gdF.setText(getString(R.string.edit));
        this.iNT = false;
        this.iNR.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    private void cxl() {
        int size = this.iNH.size();
        this.iNM.setText(getString(R.string.delete) + "(" + size + ")");
        if (size == 0) {
            this.iNM.setEnabled(false);
        } else {
            this.iNM.setEnabled(true);
        }
        ao.setBackgroundResource(this.iNM, R.drawable.btn_delete_groupupdates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxm() {
        this.iNJ = new a();
        this.iNJ.execute(this.iNH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BaseAdapter {
        private b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (h.this.iNG != null) {
                return h.this.iNG.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (h.this.iNG != null && i <= h.this.iNG.size()) {
                return h.this.iNG.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (h.this.iNG == null || i > h.this.iNG.size()) {
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
            Bitmap bitmap = ((c) h.this.iNG.get(i)).iNW;
            if (bitmap != null) {
                eVar.iNY.setImageBitmap(bitmap);
            } else {
                ao.setImageResource(eVar.iNY, R.drawable.pic_image_h_not);
            }
            if (h.this.iNT) {
                if (h.this.iNH.contains(((c) h.this.iNG.get(i)).id)) {
                    ao.setImageResource(eVar.iNX, R.drawable.btn_expression_choose_s);
                } else {
                    ao.setImageResource(eVar.iNX, R.drawable.btn_expression_choose_n);
                }
                eVar.iNX.setVisibility(0);
                eVar.iNX.setTag(((c) h.this.iNG.get(i)).id);
            } else {
                eVar.iNX.setVisibility(8);
            }
            eVar.eli.setText(((c) h.this.iNG.get(i)).name);
            h.this.getLayoutMode().onModeChanged(view);
            return view;
        }

        private View createView() {
            View inflate = View.inflate(h.this.getPageContext().getPageActivity(), R.layout.emotion_manage_list_item, null);
            e eVar = new e();
            eVar.iNX = (ImageView) inflate.findViewById(R.id.emotion_group_select);
            eVar.iNY = (ImageView) inflate.findViewById(R.id.emotion_group_photo);
            eVar.eli = (TextView) inflate.findViewById(R.id.emotion_group_name);
            inflate.setTag(eVar);
            return inflate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c {
        boolean iNV;
        Bitmap iNW;
        String id;
        String name;

        private c() {
            this.iNV = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class d extends BdAsyncTask<String, Integer, List<c>> {
        private d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: R */
        public List<c> doInBackground(String... strArr) {
            List<MyEmotionGroupData> IL = com.baidu.tieba.faceshop.a.cxd().IL(TbadkApplication.getCurrentAccount());
            List<EmotionGroupData> xO = i.cxt().xO(1);
            LinkedList linkedList = new LinkedList();
            for (MyEmotionGroupData myEmotionGroupData : IL) {
                Iterator<EmotionGroupData> it = xO.iterator();
                while (true) {
                    if (it.hasNext()) {
                        EmotionGroupData next = it.next();
                        if (myEmotionGroupData.getGroupId().equals(next.getGroupId()) && com.baidu.tieba.faceshop.b.IM(next.getGroupId())) {
                            c cVar = new c();
                            cVar.id = next.getGroupId();
                            cVar.name = next.getGroupName();
                            cVar.iNW = com.baidu.tieba.faceshop.b.eQ(cVar.id, "list.png");
                            linkedList.add(cVar);
                            break;
                        }
                    }
                }
            }
            IL.clear();
            xO.clear();
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
            h.this.iNG = list;
            h.this.pW(false);
            h.this.hideProgressBar();
            h.this.cxi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
                i = com.baidu.tieba.faceshop.a.cxd().a(myEmotionGroupData) ? i + 1 : i;
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
                h.this.iNT = true;
                h.this.pW(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class e {
        TextView eli;
        ImageView iNX;
        ImageView iNY;

        private e() {
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onBackPressed() {
        if (this.iNT) {
            cxk();
            this.iNH.clear();
            this.iNT = false;
            this.iNS.notifyDataSetChanged();
            return;
        }
        super.onBackPressed();
    }
}
