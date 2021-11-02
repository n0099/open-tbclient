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
/* loaded from: classes9.dex */
public class EmotionManageActivity extends ProxyAdkBaseActivity<EmotionManageActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<f> f47818e;

    /* renamed from: f  reason: collision with root package name */
    public final List<String> f47819f;

    /* renamed from: g  reason: collision with root package name */
    public g f47820g;

    /* renamed from: h  reason: collision with root package name */
    public d f47821h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f47822i;
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
    public boolean t;
    public final View.OnClickListener u;
    public final AdapterView.OnItemClickListener v;
    public final CustomMessageListener w;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionManageActivity f47823e;

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
            this.f47823e = emotionManageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f47823e.l) {
                    this.f47823e.M();
                } else if (view == this.f47823e.m) {
                    if (this.f47823e.t) {
                        this.f47823e.y();
                        this.f47823e.f47819f.clear();
                    } else {
                        this.f47823e.z();
                    }
                    this.f47823e.s.notifyDataSetChanged();
                } else if (view == this.f47823e.q) {
                    IntentConfig intentConfig = new IntentConfig(this.f47823e.getActivity());
                    intentConfig.getIntent().putExtra("emotion_manage", "emotion_manage");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902015, intentConfig));
                    this.f47823e.y();
                    this.f47823e.I(true);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionManageActivity f47824e;

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
            this.f47824e = emotionManageActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            h hVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (this.f47824e.t) {
                    if (this.f47824e.f47818e.get(i2) == null || (hVar = (h) view.getTag()) == null) {
                        return;
                    }
                    Object tag = hVar.f47834a.getTag();
                    if (tag instanceof String) {
                        String str = (String) tag;
                        for (f fVar : this.f47824e.f47818e) {
                            if (fVar.f47828a.equals(str)) {
                                if (this.f47824e.f47819f.contains(str)) {
                                    SkinManager.setImageResource(hVar.f47834a, R.drawable.btn_expression_choose_n);
                                    this.f47824e.f47819f.remove(str);
                                    this.f47824e.K(str);
                                    fVar.f47830c = false;
                                } else {
                                    SkinManager.setImageResource(hVar.f47834a, R.drawable.btn_expression_choose_s);
                                    this.f47824e.x(str);
                                    fVar.f47830c = true;
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                this.f47824e.sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.f47824e.getPageContext().getPageActivity(), ((f) this.f47824e.f47818e.get(i2)).f47828a, false, "emotion_manage")));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionManageActivity f47825a;

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
            this.f47825a = emotionManageActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001117) {
                this.f47825a.f47820g = new g(this.f47825a, null);
                this.f47825a.f47820g.execute(new String[0]);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends BdAsyncTask<List<String>, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionManageActivity f47826a;

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
            this.f47826a = emotionManageActivity;
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
                        if (b.a.r0.s0.a.c().b(myEmotionGroupData)) {
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
                    this.f47826a.t = true;
                    this.f47826a.I(true);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionManageActivity f47827e;

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
            this.f47827e = emotionManageActivity;
        }

        public final View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = View.inflate(this.f47827e.getPageContext().getPageActivity(), R.layout.emotion_manage_list_item, null);
                h hVar = new h(null);
                hVar.f47834a = (ImageView) inflate.findViewById(R.id.emotion_group_select);
                hVar.f47835b = (ImageView) inflate.findViewById(R.id.emotion_group_photo);
                hVar.f47836c = (TextView) inflate.findViewById(R.id.emotion_group_name);
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
                if (this.f47827e.f47818e == null) {
                    return 0;
                }
                return this.f47827e.f47818e.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (this.f47827e.f47818e == null || i2 > this.f47827e.f47818e.size()) {
                    return null;
                }
                return this.f47827e.f47818e.get(i2);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                if (this.f47827e.f47818e == null || i2 > this.f47827e.f47818e.size()) {
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
                Bitmap bitmap = ((f) this.f47827e.f47818e.get(i2)).f47831d;
                if (bitmap != null) {
                    hVar.f47835b.setImageBitmap(bitmap);
                } else {
                    SkinManager.setImageResource(hVar.f47835b, R.drawable.pic_image_h_not);
                }
                if (this.f47827e.t) {
                    if (this.f47827e.f47819f.contains(((f) this.f47827e.f47818e.get(i2)).f47828a)) {
                        SkinManager.setImageResource(hVar.f47834a, R.drawable.btn_expression_choose_s);
                    } else {
                        SkinManager.setImageResource(hVar.f47834a, R.drawable.btn_expression_choose_n);
                    }
                    hVar.f47834a.setVisibility(0);
                    hVar.f47834a.setTag(((f) this.f47827e.f47818e.get(i2)).f47828a);
                } else {
                    hVar.f47834a.setVisibility(8);
                }
                hVar.f47836c.setText(((f) this.f47827e.f47818e.get(i2)).f47829b);
                this.f47827e.getLayoutMode().j(view);
                return view;
            }
            return (View) invokeILL.objValue;
        }

        public /* synthetic */ e(EmotionManageActivity emotionManageActivity, a aVar) {
            this(emotionManageActivity);
        }
    }

    /* loaded from: classes9.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f47828a;

        /* renamed from: b  reason: collision with root package name */
        public String f47829b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f47830c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap f47831d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionManageActivity f47832e;

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
            this.f47832e = emotionManageActivity;
        }

        public /* synthetic */ f(EmotionManageActivity emotionManageActivity, a aVar) {
            this(emotionManageActivity);
        }
    }

    /* loaded from: classes9.dex */
    public class g extends BdAsyncTask<String, Integer, List<f>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EmotionManageActivity f47833a;

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
            this.f47833a = emotionManageActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<f> doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                List<MyEmotionGroupData> h2 = b.a.r0.s0.a.c().h(TbadkCoreApplication.getCurrentAccount());
                List<EmotionGroupData> l = b.a.r0.s0.g.k().l(1);
                LinkedList linkedList = new LinkedList();
                for (MyEmotionGroupData myEmotionGroupData : h2) {
                    Iterator<EmotionGroupData> it = l.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            EmotionGroupData next = it.next();
                            if (myEmotionGroupData.getGroupId().equals(next.getGroupId()) && b.a.r0.s0.b.d(next.getGroupId())) {
                                f fVar = new f(this.f47833a, null);
                                fVar.f47828a = next.getGroupId();
                                fVar.f47829b = next.getGroupName();
                                fVar.f47831d = b.a.r0.s0.b.f(fVar.f47828a, "list.png");
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
                this.f47833a.f47818e = list;
                this.f47833a.I(false);
                this.f47833a.hideProgressBar();
                this.f47833a.J();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onPreExecute();
                this.f47833a.showProgressBar();
            }
        }

        public /* synthetic */ g(EmotionManageActivity emotionManageActivity, a aVar) {
            this(emotionManageActivity);
        }
    }

    /* loaded from: classes9.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageView f47834a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f47835b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f47836c;

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
        this.f47819f = new LinkedList();
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
            this.f47820g = gVar;
            gVar.execute(new String[0]);
            e eVar = new e(this, null);
            this.s = eVar;
            this.p.setAdapter((ListAdapter) eVar);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f47822i = (LinearLayout) findViewById(R.id.emotion_manage_root);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.j = navigationBar;
            navigationBar.setTitleText(R.string.title_activity_emotion_manage);
            this.k = this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            NavigationBar navigationBar2 = this.j;
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_LEFT;
            this.l = navigationBar2.addTextButton(controlAlign, getString(R.string.delete) + "(" + this.f47819f.size() + SmallTailInfo.EMOTION_SUFFIX, this.u, true);
            D();
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
            getLayoutMode().j(this.f47822i);
            getLayoutMode().j(this.r);
            y();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.f47819f.size();
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

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.f47819f.clear();
            } else {
                for (String str : this.f47819f) {
                    boolean z2 = false;
                    Iterator<f> it = this.f47818e.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (str.equals(it.next().f47828a)) {
                                z2 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z2) {
                        this.f47819f.remove(str);
                    }
                }
            }
            D();
            J();
            this.s.notifyDataSetChanged();
        }
    }

    public final void J() {
        List<f> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.f47818e) == null) {
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

    public final void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f47819f.remove(str);
            D();
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d dVar = new d(this, null);
            this.f47821h = dVar;
            dVar.execute(this.f47819f);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.t) {
                y();
                this.f47819f.clear();
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
            this.j.onChangeSkinType(getPageContext(), i2);
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
            I(true);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            d dVar = this.f47821h;
            if (dVar != null) {
                dVar.cancel(true);
                this.f47821h = null;
            }
        }
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || this.f47819f.contains(str)) {
            return;
        }
        this.f47819f.add(str);
        D();
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
            D();
            this.m.setText(getString(R.string.cancel));
            this.t = true;
            this.r.setVisibility(8);
        }
    }
}
