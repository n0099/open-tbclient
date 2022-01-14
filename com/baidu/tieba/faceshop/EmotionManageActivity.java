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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes12.dex */
public class EmotionManageActivity extends ProxyAdkBaseActivity<EmotionManageActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<f> f42732e;

    /* renamed from: f  reason: collision with root package name */
    public final List<String> f42733f;

    /* renamed from: g  reason: collision with root package name */
    public g f42734g;

    /* renamed from: h  reason: collision with root package name */
    public d f42735h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f42736i;

    /* renamed from: j  reason: collision with root package name */
    public NavigationBar f42737j;
    public View k;
    public TextView l;
    public TextView m;
    public TextView n;
    public ImageView o;
    public BdListView p;
    public TextView q;
    public View r;
    public e s;
    public boolean t;
    public final View.OnClickListener u;
    public final AdapterView.OnItemClickListener v;
    public final CustomMessageListener w;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionManageActivity f42738e;

        public a(EmotionManageActivity emotionManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42738e = emotionManageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f42738e.l) {
                    this.f42738e.G();
                } else if (view == this.f42738e.m) {
                    if (this.f42738e.t) {
                        this.f42738e.y();
                        this.f42738e.f42733f.clear();
                    } else {
                        this.f42738e.z();
                    }
                    this.f42738e.s.notifyDataSetChanged();
                } else if (view == this.f42738e.q) {
                    IntentConfig intentConfig = new IntentConfig(this.f42738e.getActivity());
                    intentConfig.getIntent().putExtra("emotion_manage", "emotion_manage");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902015, intentConfig));
                    this.f42738e.y();
                    this.f42738e.D(true);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionManageActivity f42739e;

        public b(EmotionManageActivity emotionManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42739e = emotionManageActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            h hVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (this.f42739e.t) {
                    if (this.f42739e.f42732e.get(i2) == null || (hVar = (h) view.getTag()) == null) {
                        return;
                    }
                    Object tag = hVar.a.getTag();
                    if (tag instanceof String) {
                        String str = (String) tag;
                        for (f fVar : this.f42739e.f42732e) {
                            if (fVar.a.equals(str)) {
                                if (this.f42739e.f42733f.contains(str)) {
                                    SkinManager.setImageResource(hVar.a, R.drawable.btn_expression_choose_n);
                                    this.f42739e.f42733f.remove(str);
                                    this.f42739e.F(str);
                                    fVar.f42742c = false;
                                } else {
                                    SkinManager.setImageResource(hVar.a, R.drawable.btn_expression_choose_s);
                                    this.f42739e.x(str);
                                    fVar.f42742c = true;
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                this.f42739e.sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.f42739e.getPageContext().getPageActivity(), ((f) this.f42739e.f42732e.get(i2)).a, false, "emotion_manage")));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionManageActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(EmotionManageActivity emotionManageActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionManageActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001117) {
                this.a.f42734g = new g(this.a, null);
                this.a.f42734g.execute(new String[0]);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends BdAsyncTask<List<String>, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionManageActivity a;

        public d(EmotionManageActivity emotionManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionManageActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(List<String>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                int i2 = 0;
                List<String> list = listArr[0];
                if (list != null && !list.isEmpty()) {
                    for (String str : list) {
                        MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
                        myEmotionGroupData.setGroupId(str);
                        myEmotionGroupData.setUid(TbadkCoreApplication.getCurrentAccount());
                        if (c.a.t0.y0.a.c().b(myEmotionGroupData)) {
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
            return (Boolean) invokeL.objValue;
        }

        public /* synthetic */ d(EmotionManageActivity emotionManageActivity, a aVar) {
            this(emotionManageActivity);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                super.onPostExecute((d) bool);
                if (bool.booleanValue()) {
                    MessageManager.getInstance().runTask(2004603, (Class) null);
                    this.a.t = true;
                    this.a.D(true);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionManageActivity f42740e;

        public e(EmotionManageActivity emotionManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42740e = emotionManageActivity;
        }

        public final View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = View.inflate(this.f42740e.getPageContext().getPageActivity(), R.layout.emotion_manage_list_item, null);
                h hVar = new h(null);
                hVar.a = (ImageView) inflate.findViewById(R.id.emotion_group_select);
                hVar.f42745b = (ImageView) inflate.findViewById(R.id.emotion_group_photo);
                hVar.f42746c = (TextView) inflate.findViewById(R.id.emotion_group_name);
                inflate.setTag(hVar);
                return inflate;
            }
            return (View) invokeV.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f42740e.f42732e == null) {
                    return 0;
                }
                return this.f42740e.f42732e.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (this.f42740e.f42732e == null || i2 > this.f42740e.f42732e.size()) {
                    return null;
                }
                return this.f42740e.f42732e.get(i2);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                if (this.f42740e.f42732e == null || i2 > this.f42740e.f42732e.size()) {
                    return 0L;
                }
                return i2;
            }
            return invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    view = a();
                }
                h hVar = (h) view.getTag();
                Bitmap bitmap = ((f) this.f42740e.f42732e.get(i2)).f42743d;
                if (bitmap != null) {
                    hVar.f42745b.setImageBitmap(bitmap);
                } else {
                    SkinManager.setImageResource(hVar.f42745b, R.drawable.pic_image_h_not);
                }
                if (this.f42740e.t) {
                    if (this.f42740e.f42733f.contains(((f) this.f42740e.f42732e.get(i2)).a)) {
                        SkinManager.setImageResource(hVar.a, R.drawable.btn_expression_choose_s);
                    } else {
                        SkinManager.setImageResource(hVar.a, R.drawable.btn_expression_choose_n);
                    }
                    hVar.a.setVisibility(0);
                    hVar.a.setTag(((f) this.f42740e.f42732e.get(i2)).a);
                } else {
                    hVar.a.setVisibility(8);
                }
                hVar.f42746c.setText(((f) this.f42740e.f42732e.get(i2)).f42741b);
                this.f42740e.getLayoutMode().j(view);
                return view;
            }
            return (View) invokeILL.objValue;
        }

        public /* synthetic */ e(EmotionManageActivity emotionManageActivity, a aVar) {
            this(emotionManageActivity);
        }
    }

    /* loaded from: classes12.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f42741b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f42742c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap f42743d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionManageActivity f42744e;

        public f(EmotionManageActivity emotionManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42744e = emotionManageActivity;
        }

        public /* synthetic */ f(EmotionManageActivity emotionManageActivity, a aVar) {
            this(emotionManageActivity);
        }
    }

    /* loaded from: classes12.dex */
    public class g extends BdAsyncTask<String, Integer, List<f>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionManageActivity a;

        public g(EmotionManageActivity emotionManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionManageActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<f> doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                List<MyEmotionGroupData> h2 = c.a.t0.y0.a.c().h(TbadkCoreApplication.getCurrentAccount());
                List<EmotionGroupData> l = c.a.t0.y0.g.k().l(1);
                LinkedList linkedList = new LinkedList();
                for (MyEmotionGroupData myEmotionGroupData : h2) {
                    Iterator<EmotionGroupData> it = l.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            EmotionGroupData next = it.next();
                            if (myEmotionGroupData.getGroupId().equals(next.getGroupId()) && c.a.t0.y0.b.d(next.getGroupId())) {
                                f fVar = new f(this.a, null);
                                fVar.a = next.getGroupId();
                                fVar.f42741b = next.getGroupName();
                                fVar.f42743d = c.a.t0.y0.b.f(fVar.a, "list.png");
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
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<f> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                super.onPostExecute(list);
                if (list == null) {
                    list = new LinkedList<>();
                }
                this.a.f42732e = list;
                this.a.D(false);
                this.a.hideProgressBar();
                this.a.E();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onPreExecute();
                this.a.showProgressBar();
            }
        }

        public /* synthetic */ g(EmotionManageActivity emotionManageActivity, a aVar) {
            this(emotionManageActivity);
        }
    }

    /* loaded from: classes12.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f42745b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f42746c;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    public EmotionManageActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42733f = new LinkedList();
        this.t = false;
        this.u = new a(this);
        this.v = new b(this);
        this.w = new c(this, 0);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            registerListener(2001117, this.w);
            g gVar = new g(this, null);
            this.f42734g = gVar;
            gVar.execute(new String[0]);
            e eVar = new e(this, null);
            this.s = eVar;
            this.p.setAdapter((ListAdapter) eVar);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f42736i = (LinearLayout) findViewById(R.id.emotion_manage_root);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.f42737j = navigationBar;
            navigationBar.setTitleText(R.string.title_activity_emotion_manage);
            this.k = this.f42737j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            NavigationBar navigationBar2 = this.f42737j;
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_LEFT;
            this.l = navigationBar2.addTextButton(controlAlign, getString(R.string.delete) + "(" + this.f42733f.size() + SmallTailInfo.EMOTION_SUFFIX, this.u, true);
            C();
            TextView addTextButton = this.f42737j.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.edit), this.u);
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
            getLayoutMode().j(this.f42736i);
            getLayoutMode().j(this.r);
            y();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.f42733f.size();
            TextView textView = this.l;
            textView.setText(getString(R.string.delete) + "(" + size + SmallTailInfo.EMOTION_SUFFIX);
            if (size == 0) {
                this.l.setEnabled(false);
            } else {
                this.l.setEnabled(true);
            }
            SkinManager.setBackgroundResource(this.l, R.drawable.btn_delete_groupupdates);
        }
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f42733f.clear();
            } else {
                for (String str : this.f42733f) {
                    boolean z2 = false;
                    Iterator<f> it = this.f42732e.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (str.equals(it.next().a)) {
                                z2 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z2) {
                        this.f42733f.remove(str);
                    }
                }
            }
            C();
            E();
            this.s.notifyDataSetChanged();
        }
    }

    public final void E() {
        List<f> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.f42732e) == null) {
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

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f42733f.remove(str);
            C();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d dVar = new d(this, null);
            this.f42735h = dVar;
            dVar.execute(this.f42733f);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.t) {
                y();
                this.f42733f.clear();
                this.t = false;
                this.s.notifyDataSetChanged();
                return;
            }
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.f42737j.onChangeSkinType(getPageContext(), i2);
            SkinManager.setBackgroundResource(this.l, R.drawable.btn_delete_groupupdates);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.activity_emotion_manage);
            B();
            A();
            D(true);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            d dVar = this.f42735h;
            if (dVar != null) {
                dVar.cancel(true);
                this.f42735h = null;
            }
        }
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || this.f42733f.contains(str)) {
            return;
        }
        this.f42733f.add(str);
        C();
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            this.m.setText(getString(R.string.edit));
            this.t = false;
            this.r.setVisibility(0);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            C();
            this.m.setText(getString(R.string.cancel));
            this.t = true;
            this.r.setVisibility(8);
        }
    }
}
