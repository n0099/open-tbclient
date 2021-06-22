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
    public List<f> f14747e;

    /* renamed from: g  reason: collision with root package name */
    public g f14749g;

    /* renamed from: h  reason: collision with root package name */
    public d f14750h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f14751i;
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
    public final List<String> f14748f = new LinkedList();
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
                EmotionManageActivity.this.J();
            } else if (view == EmotionManageActivity.this.m) {
                if (EmotionManageActivity.this.t) {
                    EmotionManageActivity.this.y();
                    EmotionManageActivity.this.f14748f.clear();
                } else {
                    EmotionManageActivity.this.z();
                }
                EmotionManageActivity.this.s.notifyDataSetChanged();
            } else if (view == EmotionManageActivity.this.q) {
                IntentConfig intentConfig = new IntentConfig(EmotionManageActivity.this.getActivity());
                intentConfig.getIntent().putExtra("emotion_manage", "emotion_manage");
                MessageManager.getInstance().sendMessage(new CustomMessage(2902015, intentConfig));
                EmotionManageActivity.this.y();
                EmotionManageActivity.this.G(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            h hVar;
            if (EmotionManageActivity.this.t) {
                if (EmotionManageActivity.this.f14747e.get(i2) == null || (hVar = (h) view.getTag()) == null) {
                    return;
                }
                Object tag = hVar.f14763a.getTag();
                if (tag instanceof String) {
                    String str = (String) tag;
                    for (f fVar : EmotionManageActivity.this.f14747e) {
                        if (fVar.f14757a.equals(str)) {
                            if (EmotionManageActivity.this.f14748f.contains(str)) {
                                SkinManager.setImageResource(hVar.f14763a, R.drawable.btn_expression_choose_n);
                                EmotionManageActivity.this.f14748f.remove(str);
                                EmotionManageActivity.this.I(str);
                                fVar.f14759c = false;
                            } else {
                                SkinManager.setImageResource(hVar.f14763a, R.drawable.btn_expression_choose_s);
                                EmotionManageActivity.this.x(str);
                                fVar.f14759c = true;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            EmotionManageActivity.this.sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(EmotionManageActivity.this.getPageContext().getPageActivity(), ((f) EmotionManageActivity.this.f14747e.get(i2)).f14757a, false, "emotion_manage")));
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001117) {
                EmotionManageActivity.this.f14749g = new g(EmotionManageActivity.this, null);
                EmotionManageActivity.this.f14749g.execute(new String[0]);
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
            int i2 = 0;
            List<String> list = listArr[0];
            if (list != null && !list.isEmpty()) {
                for (String str : list) {
                    MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
                    myEmotionGroupData.setGroupId(str);
                    myEmotionGroupData.setUid(TbadkCoreApplication.getCurrentAccount());
                    if (d.a.o0.m0.a.c().b(myEmotionGroupData)) {
                        i2++;
                    }
                }
                if (i2 > 0) {
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
            hVar.f14763a = (ImageView) inflate.findViewById(R.id.emotion_group_select);
            hVar.f14764b = (ImageView) inflate.findViewById(R.id.emotion_group_photo);
            hVar.f14765c = (TextView) inflate.findViewById(R.id.emotion_group_name);
            inflate.setTag(hVar);
            return inflate;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (EmotionManageActivity.this.f14747e == null) {
                return 0;
            }
            return EmotionManageActivity.this.f14747e.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            if (EmotionManageActivity.this.f14747e == null || i2 > EmotionManageActivity.this.f14747e.size()) {
                return null;
            }
            return EmotionManageActivity.this.f14747e.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            if (EmotionManageActivity.this.f14747e == null || i2 > EmotionManageActivity.this.f14747e.size()) {
                return 0L;
            }
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = a();
            }
            h hVar = (h) view.getTag();
            Bitmap bitmap = ((f) EmotionManageActivity.this.f14747e.get(i2)).f14760d;
            if (bitmap != null) {
                hVar.f14764b.setImageBitmap(bitmap);
            } else {
                SkinManager.setImageResource(hVar.f14764b, R.drawable.pic_image_h_not);
            }
            if (EmotionManageActivity.this.t) {
                if (EmotionManageActivity.this.f14748f.contains(((f) EmotionManageActivity.this.f14747e.get(i2)).f14757a)) {
                    SkinManager.setImageResource(hVar.f14763a, R.drawable.btn_expression_choose_s);
                } else {
                    SkinManager.setImageResource(hVar.f14763a, R.drawable.btn_expression_choose_n);
                }
                hVar.f14763a.setVisibility(0);
                hVar.f14763a.setTag(((f) EmotionManageActivity.this.f14747e.get(i2)).f14757a);
            } else {
                hVar.f14763a.setVisibility(8);
            }
            hVar.f14765c.setText(((f) EmotionManageActivity.this.f14747e.get(i2)).f14758b);
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
        public String f14757a;

        /* renamed from: b  reason: collision with root package name */
        public String f14758b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f14759c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap f14760d;

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
            List<MyEmotionGroupData> h2 = d.a.o0.m0.a.c().h(TbadkCoreApplication.getCurrentAccount());
            List<EmotionGroupData> l = d.a.o0.m0.g.k().l(1);
            LinkedList linkedList = new LinkedList();
            for (MyEmotionGroupData myEmotionGroupData : h2) {
                Iterator<EmotionGroupData> it = l.iterator();
                while (true) {
                    if (it.hasNext()) {
                        EmotionGroupData next = it.next();
                        if (myEmotionGroupData.getGroupId().equals(next.getGroupId()) && d.a.o0.m0.b.d(next.getGroupId())) {
                            f fVar = new f(EmotionManageActivity.this, null);
                            fVar.f14757a = next.getGroupId();
                            fVar.f14758b = next.getGroupName();
                            fVar.f14760d = d.a.o0.m0.b.f(fVar.f14757a, "list.png");
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
            EmotionManageActivity.this.f14747e = list;
            EmotionManageActivity.this.G(false);
            EmotionManageActivity.this.hideProgressBar();
            EmotionManageActivity.this.H();
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
        public ImageView f14763a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f14764b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14765c;

        public h() {
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    public final void A() {
        registerListener(2001117, this.w);
        g gVar = new g(this, null);
        this.f14749g = gVar;
        gVar.execute(new String[0]);
        e eVar = new e(this, null);
        this.s = eVar;
        this.p.setAdapter((ListAdapter) eVar);
    }

    public final void B() {
        this.f14751i = (LinearLayout) findViewById(R.id.emotion_manage_root);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        navigationBar.setTitleText(R.string.title_activity_emotion_manage);
        this.k = this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        NavigationBar navigationBar2 = this.j;
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_LEFT;
        this.l = navigationBar2.addTextButton(controlAlign, getString(R.string.delete) + "(" + this.f14748f.size() + SmallTailInfo.EMOTION_SUFFIX, this.u, true);
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
        getLayoutMode().j(this.f14751i);
        getLayoutMode().j(this.r);
        y();
    }

    @SuppressLint({"ResourceAsColor"})
    public final void F() {
        int size = this.f14748f.size();
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
            this.f14748f.clear();
        } else {
            for (String str : this.f14748f) {
                boolean z2 = false;
                Iterator<f> it = this.f14747e.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (str.equals(it.next().f14757a)) {
                            z2 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z2) {
                    this.f14748f.remove(str);
                }
            }
        }
        F();
        H();
        this.s.notifyDataSetChanged();
    }

    public final void H() {
        List<f> list = this.f14747e;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            this.n.setText(R.string.emotion_manage_title_nodata);
            this.m.setEnabled(false);
            this.o.setVisibility(8);
            y();
            return;
        }
        this.n.setText(R.string.emotion_manage_title);
        this.m.setEnabled(true);
        this.o.setVisibility(0);
    }

    public final void I(String str) {
        this.f14748f.remove(str);
        F();
    }

    public final void J() {
        d dVar = new d(this, null);
        this.f14750h = dVar;
        dVar.execute(this.f14748f);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onBackPressed() {
        if (this.t) {
            y();
            this.f14748f.clear();
            this.t = false;
            this.s.notifyDataSetChanged();
            return;
        }
        super.onBackPressed();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.j.onChangeSkinType(getPageContext(), i2);
        SkinManager.setBackgroundResource(this.l, R.drawable.btn_delete_groupupdates);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_emotion_manage);
        B();
        A();
        G(true);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        d dVar = this.f14750h;
        if (dVar != null) {
            dVar.cancel(true);
            this.f14750h = null;
        }
    }

    public final void x(String str) {
        if (this.f14748f.contains(str)) {
            return;
        }
        this.f14748f.add(str);
        F();
    }

    public final void y() {
        this.k.setVisibility(0);
        this.l.setVisibility(8);
        this.m.setText(getString(R.string.edit));
        this.t = false;
        this.r.setVisibility(0);
    }

    public final void z() {
        this.k.setVisibility(8);
        this.l.setVisibility(0);
        F();
        this.m.setText(getString(R.string.cancel));
        this.t = true;
        this.r.setVisibility(8);
    }
}
