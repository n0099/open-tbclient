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
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class EmotionManageActivity extends ProxyAdkBaseActivity<EmotionManageActivity> {

    /* renamed from: e  reason: collision with root package name */
    public List<f> f15250e;

    /* renamed from: g  reason: collision with root package name */
    public g f15252g;

    /* renamed from: h  reason: collision with root package name */
    public d f15253h;
    public LinearLayout i;
    public NavigationBar j;
    public View k;
    public TextView l;
    public TextView m;
    public TextView n;
    public ImageView o;
    public BdListView p;
    public TextView q;
    public View r;
    public e s;

    /* renamed from: f  reason: collision with root package name */
    public final List<String> f15251f = new LinkedList();
    public boolean t = false;
    public final View.OnClickListener u = new a();
    public final AdapterView.OnItemClickListener v = new b();
    public final CustomMessageListener w = new c(0);

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == EmotionManageActivity.this.l) {
                EmotionManageActivity.this.K();
            } else if (view == EmotionManageActivity.this.m) {
                if (EmotionManageActivity.this.t) {
                    EmotionManageActivity.this.z();
                    EmotionManageActivity.this.f15251f.clear();
                } else {
                    EmotionManageActivity.this.A();
                }
                EmotionManageActivity.this.s.notifyDataSetChanged();
            } else if (view == EmotionManageActivity.this.q) {
                IntentConfig intentConfig = new IntentConfig(EmotionManageActivity.this.getActivity());
                intentConfig.getIntent().putExtra("emotion_manage", "emotion_manage");
                MessageManager.getInstance().sendMessage(new CustomMessage(2902015, intentConfig));
                EmotionManageActivity.this.z();
                EmotionManageActivity.this.G(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            h hVar;
            if (EmotionManageActivity.this.t) {
                if (EmotionManageActivity.this.f15250e.get(i) == null || (hVar = (h) view.getTag()) == null) {
                    return;
                }
                Object tag = hVar.f15265a.getTag();
                if (tag instanceof String) {
                    String str = (String) tag;
                    for (f fVar : EmotionManageActivity.this.f15250e) {
                        if (fVar.f15259a.equals(str)) {
                            if (EmotionManageActivity.this.f15251f.contains(str)) {
                                SkinManager.setImageResource(hVar.f15265a, R.drawable.btn_expression_choose_n);
                                EmotionManageActivity.this.f15251f.remove(str);
                                EmotionManageActivity.this.J(str);
                                fVar.f15261c = false;
                            } else {
                                SkinManager.setImageResource(hVar.f15265a, R.drawable.btn_expression_choose_s);
                                EmotionManageActivity.this.y(str);
                                fVar.f15261c = true;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            EmotionManageActivity.this.sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(EmotionManageActivity.this.getPageContext().getPageActivity(), ((f) EmotionManageActivity.this.f15250e.get(i)).f15259a, false, "emotion_manage")));
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001117) {
                EmotionManageActivity.this.f15252g = new g(EmotionManageActivity.this, null);
                EmotionManageActivity.this.f15252g.execute(new String[0]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask<List<String>, Integer, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(List<String>... listArr) {
            int i = 0;
            List<String> list = listArr[0];
            if (list != null && !list.isEmpty()) {
                for (String str : list) {
                    MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
                    myEmotionGroupData.setGroupId(str);
                    myEmotionGroupData.setUid(TbadkCoreApplication.getCurrentAccount());
                    if (d.b.j0.l0.a.c().b(myEmotionGroupData)) {
                        i++;
                    }
                }
                if (i > 0) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            return Boolean.FALSE;
        }

        public /* synthetic */ d(EmotionManageActivity emotionManageActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((d) bool);
            if (bool.booleanValue()) {
                MessageManager.getInstance().runTask(2004603, (Class) null);
                EmotionManageActivity.this.t = true;
                EmotionManageActivity.this.G(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends BaseAdapter {
        public e() {
        }

        public final View a() {
            View inflate = View.inflate(EmotionManageActivity.this.getPageContext().getPageActivity(), R.layout.emotion_manage_list_item, null);
            h hVar = new h(null);
            hVar.f15265a = (ImageView) inflate.findViewById(R.id.emotion_group_select);
            hVar.f15266b = (ImageView) inflate.findViewById(R.id.emotion_group_photo);
            hVar.f15267c = (TextView) inflate.findViewById(R.id.emotion_group_name);
            inflate.setTag(hVar);
            return inflate;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (EmotionManageActivity.this.f15250e == null) {
                return 0;
            }
            return EmotionManageActivity.this.f15250e.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (EmotionManageActivity.this.f15250e == null || i > EmotionManageActivity.this.f15250e.size()) {
                return null;
            }
            return EmotionManageActivity.this.f15250e.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (EmotionManageActivity.this.f15250e == null || i > EmotionManageActivity.this.f15250e.size()) {
                return 0L;
            }
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = a();
            }
            h hVar = (h) view.getTag();
            Bitmap bitmap = ((f) EmotionManageActivity.this.f15250e.get(i)).f15262d;
            if (bitmap != null) {
                hVar.f15266b.setImageBitmap(bitmap);
            } else {
                SkinManager.setImageResource(hVar.f15266b, R.drawable.pic_image_h_not);
            }
            if (EmotionManageActivity.this.t) {
                if (EmotionManageActivity.this.f15251f.contains(((f) EmotionManageActivity.this.f15250e.get(i)).f15259a)) {
                    SkinManager.setImageResource(hVar.f15265a, R.drawable.btn_expression_choose_s);
                } else {
                    SkinManager.setImageResource(hVar.f15265a, R.drawable.btn_expression_choose_n);
                }
                hVar.f15265a.setVisibility(0);
                hVar.f15265a.setTag(((f) EmotionManageActivity.this.f15250e.get(i)).f15259a);
            } else {
                hVar.f15265a.setVisibility(8);
            }
            hVar.f15267c.setText(((f) EmotionManageActivity.this.f15250e.get(i)).f15260b);
            EmotionManageActivity.this.getLayoutMode().j(view);
            return view;
        }

        public /* synthetic */ e(EmotionManageActivity emotionManageActivity, a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        public String f15259a;

        /* renamed from: b  reason: collision with root package name */
        public String f15260b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f15261c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap f15262d;

        public f() {
        }

        public /* synthetic */ f(EmotionManageActivity emotionManageActivity, a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class g extends BdAsyncTask<String, Integer, List<f>> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<f> doInBackground(String... strArr) {
            List<MyEmotionGroupData> h2 = d.b.j0.l0.a.c().h(TbadkCoreApplication.getCurrentAccount());
            List<EmotionGroupData> l = d.b.j0.l0.g.k().l(1);
            LinkedList linkedList = new LinkedList();
            for (MyEmotionGroupData myEmotionGroupData : h2) {
                Iterator<EmotionGroupData> it = l.iterator();
                while (true) {
                    if (it.hasNext()) {
                        EmotionGroupData next = it.next();
                        if (myEmotionGroupData.getGroupId().equals(next.getGroupId()) && d.b.j0.l0.b.d(next.getGroupId())) {
                            f fVar = new f(EmotionManageActivity.this, null);
                            fVar.f15259a = next.getGroupId();
                            fVar.f15260b = next.getGroupName();
                            fVar.f15262d = d.b.j0.l0.b.f(fVar.f15259a, "list.png");
                            linkedList.add(fVar);
                            break;
                        }
                    }
                }
            }
            h2.clear();
            l.clear();
            return linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<f> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            EmotionManageActivity.this.f15250e = list;
            EmotionManageActivity.this.G(false);
            EmotionManageActivity.this.hideProgressBar();
            EmotionManageActivity.this.I();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            EmotionManageActivity.this.showProgressBar();
        }

        public /* synthetic */ g(EmotionManageActivity emotionManageActivity, a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f15265a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f15266b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15267c;

        public h() {
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    public final void A() {
        this.k.setVisibility(8);
        this.l.setVisibility(0);
        F();
        this.m.setText(getString(R.string.cancel));
        this.t = true;
        this.r.setVisibility(8);
    }

    public final void B() {
        registerListener(2001117, this.w);
        g gVar = new g(this, null);
        this.f15252g = gVar;
        gVar.execute(new String[0]);
        e eVar = new e(this, null);
        this.s = eVar;
        this.p.setAdapter((ListAdapter) eVar);
    }

    public final void E() {
        this.i = (LinearLayout) findViewById(R.id.emotion_manage_root);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        navigationBar.setTitleText(R.string.title_activity_emotion_manage);
        this.k = this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        NavigationBar navigationBar2 = this.j;
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_LEFT;
        this.l = navigationBar2.addTextButton(controlAlign, getString(R.string.delete) + "(" + this.f15251f.size() + SmallTailInfo.EMOTION_SUFFIX, this.u, true);
        F();
        TextView addTextButton = this.j.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.edit), this.u);
        this.m = addTextButton;
        SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0106, 1);
        this.n = (TextView) findViewById(R.id.emotion_manager_title);
        this.o = (ImageView) findViewById(R.id.emotion_manage_enter_line_list_up);
        BdListView bdListView = (BdListView) findViewById(R.id.emotion_manage_list);
        this.p = bdListView;
        bdListView.setOnItemClickListener(this.v);
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.emotion_manage_list_footer, (ViewGroup) null);
        this.r = inflate;
        this.p.addFooterView(inflate);
        TextView textView = (TextView) this.r.findViewById(R.id.emotion_manage_enter_record);
        this.q = textView;
        textView.setOnClickListener(this.u);
        getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        getLayoutMode().j(this.i);
        getLayoutMode().j(this.r);
        z();
    }

    @SuppressLint({"ResourceAsColor"})
    public final void F() {
        int size = this.f15251f.size();
        TextView textView = this.l;
        textView.setText(getString(R.string.delete) + "(" + size + SmallTailInfo.EMOTION_SUFFIX);
        if (size == 0) {
            this.l.setEnabled(false);
        } else {
            this.l.setEnabled(true);
        }
        SkinManager.setBackgroundResource(this.l, R.drawable.btn_delete_groupupdates);
    }

    public final void G(boolean z) {
        if (z) {
            this.f15251f.clear();
        } else {
            for (String str : this.f15251f) {
                boolean z2 = false;
                Iterator<f> it = this.f15250e.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (str.equals(it.next().f15259a)) {
                            z2 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z2) {
                    this.f15251f.remove(str);
                }
            }
        }
        F();
        I();
        this.s.notifyDataSetChanged();
    }

    public final void I() {
        List<f> list = this.f15250e;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            this.n.setText(R.string.emotion_manage_title_nodata);
            this.m.setEnabled(false);
            this.o.setVisibility(8);
            z();
            return;
        }
        this.n.setText(R.string.emotion_manage_title);
        this.m.setEnabled(true);
        this.o.setVisibility(0);
    }

    public final void J(String str) {
        this.f15251f.remove(str);
        F();
    }

    public final void K() {
        d dVar = new d(this, null);
        this.f15253h = dVar;
        dVar.execute(this.f15251f);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onBackPressed() {
        if (this.t) {
            z();
            this.f15251f.clear();
            this.t = false;
            this.s.notifyDataSetChanged();
            return;
        }
        super.onBackPressed();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.j.onChangeSkinType(getPageContext(), i);
        SkinManager.setBackgroundResource(this.l, R.drawable.btn_delete_groupupdates);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_emotion_manage);
        E();
        B();
        G(true);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        d dVar = this.f15253h;
        if (dVar != null) {
            dVar.cancel(true);
            this.f15253h = null;
        }
    }

    public final void y(String str) {
        if (this.f15251f.contains(str)) {
            return;
        }
        this.f15251f.add(str);
        F();
    }

    public final void z() {
        this.k.setVisibility(0);
        this.l.setVisibility(8);
        this.m.setText(getString(R.string.edit));
        this.t = false;
        this.r.setVisibility(0);
    }
}
