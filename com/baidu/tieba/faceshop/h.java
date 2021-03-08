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
/* loaded from: classes8.dex */
public class h extends ProxyAdkBaseActivity<h> {
    private TextView ghC;
    private List<c> iVk;
    private d iVm;
    private a iVn;
    private LinearLayout iVo;
    private NavigationBar iVp;
    private TextView iVq;
    private TextView iVr;
    private ImageView iVs;
    private BdListView iVt;
    private TextView iVu;
    private View iVv;
    private b iVw;
    private View mBack;
    private final List<String> iVl = new LinkedList();
    private boolean iVx = false;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.iVq) {
                h.this.cyK();
            } else if (view == h.this.ghC) {
                if (h.this.iVx) {
                    h.this.cyI();
                    h.this.iVl.clear();
                } else {
                    h.this.cyH();
                }
                h.this.iVw.notifyDataSetChanged();
            } else if (view == h.this.iVu) {
                IntentConfig intentConfig = new IntentConfig(h.this.getActivity());
                intentConfig.getIntent().putExtra("emotion_manage", "emotion_manage");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPURCHASERECORDS, intentConfig));
                h.this.cyI();
                h.this.qg(true);
            }
        }
    };
    private final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.faceshop.h.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            e eVar;
            if (h.this.iVx) {
                if (h.this.iVk.get(i) != null && (eVar = (e) view.getTag()) != null) {
                    Object tag = eVar.iVB.getTag();
                    if (tag instanceof String) {
                        String str = (String) tag;
                        for (c cVar : h.this.iVk) {
                            if (cVar.id.equals(str)) {
                                if (h.this.iVl.contains(str)) {
                                    ap.setImageResource(eVar.iVB, R.drawable.btn_expression_choose_n);
                                    h.this.iVl.remove(str);
                                    h.this.JK(str);
                                    cVar.iVz = false;
                                } else {
                                    ap.setImageResource(eVar.iVB, R.drawable.btn_expression_choose_s);
                                    h.this.JJ(str);
                                    cVar.iVz = true;
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            h.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(h.this.getPageContext().getPageActivity(), ((c) h.this.iVk.get(i)).id, false, "emotion_manage")));
        }
    };
    private final CustomMessageListener eLa = new CustomMessageListener(0) { // from class: com.baidu.tieba.faceshop.h.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001117) {
                h.this.iVm = new d();
                h.this.iVm.execute(new String[0]);
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
        if (this.iVn != null) {
            this.iVn.cancel(true);
            this.iVn = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iVp.onChangeSkinType(getPageContext(), i);
        ap.setBackgroundResource(this.iVq, R.drawable.btn_delete_groupupdates);
    }

    private void initView() {
        this.iVo = (LinearLayout) findViewById(R.id.emotion_manage_root);
        this.iVp = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.iVp.setTitleText(R.string.title_activity_emotion_manage);
        this.mBack = this.iVp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iVq = this.iVp.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.delete) + "(" + this.iVl.size() + ")", this.mOnClickListener, true);
        cyJ();
        this.ghC = this.iVp.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.edit), this.mOnClickListener);
        ap.setViewTextColor(this.ghC, R.color.CAM_X0106, 1);
        this.iVr = (TextView) findViewById(R.id.emotion_manager_title);
        this.iVs = (ImageView) findViewById(R.id.emotion_manage_enter_line_list_up);
        this.iVt = (BdListView) findViewById(R.id.emotion_manage_list);
        this.iVt.setOnItemClickListener(this.mOnItemClickListener);
        this.iVv = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.emotion_manage_list_footer, (ViewGroup) null);
        this.iVt.addFooterView(this.iVv);
        this.iVu = (TextView) this.iVv.findViewById(R.id.emotion_manage_enter_record);
        this.iVu.setOnClickListener(this.mOnClickListener);
        getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        getLayoutMode().onModeChanged(this.iVo);
        getLayoutMode().onModeChanged(this.iVv);
        cyI();
    }

    private void initData() {
        registerListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED, this.eLa);
        this.iVm = new d();
        this.iVm.execute(new String[0]);
        this.iVw = new b();
        this.iVt.setAdapter((ListAdapter) this.iVw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(boolean z) {
        boolean z2;
        if (z) {
            this.iVl.clear();
        } else {
            for (String str : this.iVl) {
                Iterator<c> it = this.iVk.iterator();
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
                    this.iVl.remove(str);
                }
            }
        }
        cyJ();
        cyG();
        this.iVw.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyG() {
        if (this.iVk != null) {
            if (this.iVk.size() == 0) {
                this.iVr.setText(R.string.emotion_manage_title_nodata);
                this.ghC.setEnabled(false);
                this.iVs.setVisibility(8);
                cyI();
                return;
            }
            this.iVr.setText(R.string.emotion_manage_title);
            this.ghC.setEnabled(true);
            this.iVs.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JJ(String str) {
        if (!this.iVl.contains(str)) {
            this.iVl.add(str);
            cyJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JK(String str) {
        this.iVl.remove(str);
        cyJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyH() {
        this.mBack.setVisibility(8);
        this.iVq.setVisibility(0);
        cyJ();
        this.ghC.setText(getString(R.string.cancel));
        this.iVx = true;
        this.iVv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyI() {
        this.mBack.setVisibility(0);
        this.iVq.setVisibility(8);
        this.ghC.setText(getString(R.string.edit));
        this.iVx = false;
        this.iVv.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    private void cyJ() {
        int size = this.iVl.size();
        this.iVq.setText(getString(R.string.delete) + "(" + size + ")");
        if (size == 0) {
            this.iVq.setEnabled(false);
        } else {
            this.iVq.setEnabled(true);
        }
        ap.setBackgroundResource(this.iVq, R.drawable.btn_delete_groupupdates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyK() {
        this.iVn = new a();
        this.iVn.execute(this.iVl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BaseAdapter {
        private b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (h.this.iVk != null) {
                return h.this.iVk.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (h.this.iVk != null && i <= h.this.iVk.size()) {
                return h.this.iVk.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (h.this.iVk == null || i > h.this.iVk.size()) {
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
            Bitmap bitmap = ((c) h.this.iVk.get(i)).iVA;
            if (bitmap != null) {
                eVar.iVC.setImageBitmap(bitmap);
            } else {
                ap.setImageResource(eVar.iVC, R.drawable.pic_image_h_not);
            }
            if (h.this.iVx) {
                if (h.this.iVl.contains(((c) h.this.iVk.get(i)).id)) {
                    ap.setImageResource(eVar.iVB, R.drawable.btn_expression_choose_s);
                } else {
                    ap.setImageResource(eVar.iVB, R.drawable.btn_expression_choose_n);
                }
                eVar.iVB.setVisibility(0);
                eVar.iVB.setTag(((c) h.this.iVk.get(i)).id);
            } else {
                eVar.iVB.setVisibility(8);
            }
            eVar.eoT.setText(((c) h.this.iVk.get(i)).name);
            h.this.getLayoutMode().onModeChanged(view);
            return view;
        }

        private View createView() {
            View inflate = View.inflate(h.this.getPageContext().getPageActivity(), R.layout.emotion_manage_list_item, null);
            e eVar = new e();
            eVar.iVB = (ImageView) inflate.findViewById(R.id.emotion_group_select);
            eVar.iVC = (ImageView) inflate.findViewById(R.id.emotion_group_photo);
            eVar.eoT = (TextView) inflate.findViewById(R.id.emotion_group_name);
            inflate.setTag(eVar);
            return inflate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c {
        Bitmap iVA;
        boolean iVz;
        String id;
        String name;

        private c() {
            this.iVz = false;
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
            List<MyEmotionGroupData> JG = com.baidu.tieba.faceshop.a.cyB().JG(TbadkApplication.getCurrentAccount());
            List<EmotionGroupData> xZ = i.cyR().xZ(1);
            LinkedList linkedList = new LinkedList();
            for (MyEmotionGroupData myEmotionGroupData : JG) {
                Iterator<EmotionGroupData> it = xZ.iterator();
                while (true) {
                    if (it.hasNext()) {
                        EmotionGroupData next = it.next();
                        if (myEmotionGroupData.getGroupId().equals(next.getGroupId()) && com.baidu.tieba.faceshop.b.JH(next.getGroupId())) {
                            c cVar = new c();
                            cVar.id = next.getGroupId();
                            cVar.name = next.getGroupName();
                            cVar.iVA = com.baidu.tieba.faceshop.b.eQ(cVar.id, "list.png");
                            linkedList.add(cVar);
                            break;
                        }
                    }
                }
            }
            JG.clear();
            xZ.clear();
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
            h.this.iVk = list;
            h.this.qg(false);
            h.this.hideProgressBar();
            h.this.cyG();
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
                i = com.baidu.tieba.faceshop.a.cyB().a(myEmotionGroupData) ? i + 1 : i;
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
                h.this.iVx = true;
                h.this.qg(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class e {
        TextView eoT;
        ImageView iVB;
        ImageView iVC;

        private e() {
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onBackPressed() {
        if (this.iVx) {
            cyI();
            this.iVl.clear();
            this.iVx = false;
            this.iVw.notifyDataSetChanged();
            return;
        }
        super.onBackPressed();
    }
}
