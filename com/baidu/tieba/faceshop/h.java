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
/* loaded from: classes9.dex */
public class h extends ProxyAdkBaseActivity<h> {
    private TextView gio;
    private List<c> iSn;
    private d iSp;
    private a iSq;
    private LinearLayout iSr;
    private NavigationBar iSs;
    private TextView iSt;
    private TextView iSu;
    private ImageView iSv;
    private BdListView iSw;
    private TextView iSx;
    private View iSy;
    private b iSz;
    private View mBack;
    private final List<String> iSo = new LinkedList();
    private boolean iSA = false;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == h.this.iSt) {
                h.this.cBe();
            } else if (view == h.this.gio) {
                if (h.this.iSA) {
                    h.this.cBc();
                    h.this.iSo.clear();
                } else {
                    h.this.cBb();
                }
                h.this.iSz.notifyDataSetChanged();
            } else if (view == h.this.iSx) {
                IntentConfig intentConfig = new IntentConfig(h.this.getActivity());
                intentConfig.getIntent().putExtra("emotion_manage", "emotion_manage");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPURCHASERECORDS, intentConfig));
                h.this.cBc();
                h.this.qa(true);
            }
        }
    };
    private final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.faceshop.h.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            e eVar;
            if (h.this.iSA) {
                if (h.this.iSn.get(i) != null && (eVar = (e) view.getTag()) != null) {
                    Object tag = eVar.iSE.getTag();
                    if (tag instanceof String) {
                        String str = (String) tag;
                        for (c cVar : h.this.iSn) {
                            if (cVar.id.equals(str)) {
                                if (h.this.iSo.contains(str)) {
                                    ao.setImageResource(eVar.iSE, R.drawable.btn_expression_choose_n);
                                    h.this.iSo.remove(str);
                                    h.this.Ka(str);
                                    cVar.iSC = false;
                                } else {
                                    ao.setImageResource(eVar.iSE, R.drawable.btn_expression_choose_s);
                                    h.this.JZ(str);
                                    cVar.iSC = true;
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            h.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(h.this.getPageContext().getPageActivity(), ((c) h.this.iSn.get(i)).id, false, "emotion_manage")));
        }
    };
    private final CustomMessageListener eMe = new CustomMessageListener(0) { // from class: com.baidu.tieba.faceshop.h.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001117) {
                h.this.iSp = new d();
                h.this.iSp.execute(new String[0]);
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
        qa(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.iSq != null) {
            this.iSq.cancel(true);
            this.iSq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iSs.onChangeSkinType(getPageContext(), i);
        ao.setBackgroundResource(this.iSt, R.drawable.btn_delete_groupupdates);
    }

    private void initView() {
        this.iSr = (LinearLayout) findViewById(R.id.emotion_manage_root);
        this.iSs = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.iSs.setTitleText(R.string.title_activity_emotion_manage);
        this.mBack = this.iSs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iSt = this.iSs.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.delete) + "(" + this.iSo.size() + ")", this.mOnClickListener, true);
        cBd();
        this.gio = this.iSs.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.edit), this.mOnClickListener);
        ao.setViewTextColor(this.gio, R.color.CAM_X0106, 1);
        this.iSu = (TextView) findViewById(R.id.emotion_manager_title);
        this.iSv = (ImageView) findViewById(R.id.emotion_manage_enter_line_list_up);
        this.iSw = (BdListView) findViewById(R.id.emotion_manage_list);
        this.iSw.setOnItemClickListener(this.mOnItemClickListener);
        this.iSy = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.emotion_manage_list_footer, (ViewGroup) null);
        this.iSw.addFooterView(this.iSy);
        this.iSx = (TextView) this.iSy.findViewById(R.id.emotion_manage_enter_record);
        this.iSx.setOnClickListener(this.mOnClickListener);
        getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        getLayoutMode().onModeChanged(this.iSr);
        getLayoutMode().onModeChanged(this.iSy);
        cBc();
    }

    private void initData() {
        registerListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED, this.eMe);
        this.iSp = new d();
        this.iSp.execute(new String[0]);
        this.iSz = new b();
        this.iSw.setAdapter((ListAdapter) this.iSz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa(boolean z) {
        boolean z2;
        if (z) {
            this.iSo.clear();
        } else {
            for (String str : this.iSo) {
                Iterator<c> it = this.iSn.iterator();
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
                    this.iSo.remove(str);
                }
            }
        }
        cBd();
        cBa();
        this.iSz.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBa() {
        if (this.iSn != null) {
            if (this.iSn.size() == 0) {
                this.iSu.setText(R.string.emotion_manage_title_nodata);
                this.gio.setEnabled(false);
                this.iSv.setVisibility(8);
                cBc();
                return;
            }
            this.iSu.setText(R.string.emotion_manage_title);
            this.gio.setEnabled(true);
            this.iSv.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JZ(String str) {
        if (!this.iSo.contains(str)) {
            this.iSo.add(str);
            cBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ka(String str) {
        this.iSo.remove(str);
        cBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBb() {
        this.mBack.setVisibility(8);
        this.iSt.setVisibility(0);
        cBd();
        this.gio.setText(getString(R.string.cancel));
        this.iSA = true;
        this.iSy.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBc() {
        this.mBack.setVisibility(0);
        this.iSt.setVisibility(8);
        this.gio.setText(getString(R.string.edit));
        this.iSA = false;
        this.iSy.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    private void cBd() {
        int size = this.iSo.size();
        this.iSt.setText(getString(R.string.delete) + "(" + size + ")");
        if (size == 0) {
            this.iSt.setEnabled(false);
        } else {
            this.iSt.setEnabled(true);
        }
        ao.setBackgroundResource(this.iSt, R.drawable.btn_delete_groupupdates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBe() {
        this.iSq = new a();
        this.iSq.execute(this.iSo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends BaseAdapter {
        private b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (h.this.iSn != null) {
                return h.this.iSn.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (h.this.iSn != null && i <= h.this.iSn.size()) {
                return h.this.iSn.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (h.this.iSn == null || i > h.this.iSn.size()) {
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
            Bitmap bitmap = ((c) h.this.iSn.get(i)).iSD;
            if (bitmap != null) {
                eVar.iSF.setImageBitmap(bitmap);
            } else {
                ao.setImageResource(eVar.iSF, R.drawable.pic_image_h_not);
            }
            if (h.this.iSA) {
                if (h.this.iSo.contains(((c) h.this.iSn.get(i)).id)) {
                    ao.setImageResource(eVar.iSE, R.drawable.btn_expression_choose_s);
                } else {
                    ao.setImageResource(eVar.iSE, R.drawable.btn_expression_choose_n);
                }
                eVar.iSE.setVisibility(0);
                eVar.iSE.setTag(((c) h.this.iSn.get(i)).id);
            } else {
                eVar.iSE.setVisibility(8);
            }
            eVar.epX.setText(((c) h.this.iSn.get(i)).name);
            h.this.getLayoutMode().onModeChanged(view);
            return view;
        }

        private View createView() {
            View inflate = View.inflate(h.this.getPageContext().getPageActivity(), R.layout.emotion_manage_list_item, null);
            e eVar = new e();
            eVar.iSE = (ImageView) inflate.findViewById(R.id.emotion_group_select);
            eVar.iSF = (ImageView) inflate.findViewById(R.id.emotion_group_photo);
            eVar.epX = (TextView) inflate.findViewById(R.id.emotion_group_name);
            inflate.setTag(eVar);
            return inflate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c {
        boolean iSC;
        Bitmap iSD;
        String id;
        String name;

        private c() {
            this.iSC = false;
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
            List<MyEmotionGroupData> JW = com.baidu.tieba.faceshop.a.cAV().JW(TbadkApplication.getCurrentAccount());
            List<EmotionGroupData> zu = i.cBl().zu(1);
            LinkedList linkedList = new LinkedList();
            for (MyEmotionGroupData myEmotionGroupData : JW) {
                Iterator<EmotionGroupData> it = zu.iterator();
                while (true) {
                    if (it.hasNext()) {
                        EmotionGroupData next = it.next();
                        if (myEmotionGroupData.getGroupId().equals(next.getGroupId()) && com.baidu.tieba.faceshop.b.JX(next.getGroupId())) {
                            c cVar = new c();
                            cVar.id = next.getGroupId();
                            cVar.name = next.getGroupName();
                            cVar.iSD = com.baidu.tieba.faceshop.b.eR(cVar.id, "list.png");
                            linkedList.add(cVar);
                            break;
                        }
                    }
                }
            }
            JW.clear();
            zu.clear();
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
            h.this.iSn = list;
            h.this.qa(false);
            h.this.hideProgressBar();
            h.this.cBa();
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
                i = com.baidu.tieba.faceshop.a.cAV().a(myEmotionGroupData) ? i + 1 : i;
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
                h.this.iSA = true;
                h.this.qa(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class e {
        TextView epX;
        ImageView iSE;
        ImageView iSF;

        private e() {
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onBackPressed() {
        if (this.iSA) {
            cBc();
            this.iSo.clear();
            this.iSA = false;
            this.iSz.notifyDataSetChanged();
            return;
        }
        super.onBackPressed();
    }
}
