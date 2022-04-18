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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
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
import com.repackage.e96;
import com.repackage.y86;
import com.repackage.z86;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class EmotionManageActivity extends BaseActivity<EmotionManageActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ST_TYPE = "emotion_manage";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isSelectMode;
    public e mAdapter;
    public View mBack;
    public TextView mDel;
    public final List<String> mDelList;
    public d mDelTask;
    public TextView mEdit;
    public TextView mEnterRecord;
    public View mFooter;
    public BdListView mGroupList;
    public List<f> mGroups;
    public ImageView mListUpLine;
    public final CustomMessageListener mListener;
    public TextView mNotice;
    public final View.OnClickListener mOnClickListener;
    public final AdapterView.OnItemClickListener mOnItemClickListener;
    public g mQueryTask;
    public LinearLayout mRoot;
    public NavigationBar mTitleBar;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionManageActivity a;

        public a(EmotionManageActivity emotionManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionManageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.mDel) {
                    this.a.startDelete();
                } else if (view2 == this.a.mEdit) {
                    if (this.a.isSelectMode) {
                        this.a.changeTitleToNormal();
                        this.a.mDelList.clear();
                    } else {
                        this.a.changeTitleToSelection();
                    }
                    this.a.mAdapter.notifyDataSetChanged();
                } else if (view2 == this.a.mEnterRecord) {
                    IntentConfig intentConfig = new IntentConfig(this.a.getActivity());
                    intentConfig.getIntent().putExtra(EmotionManageActivity.ST_TYPE, EmotionManageActivity.ST_TYPE);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902015, intentConfig));
                    this.a.changeTitleToNormal();
                    this.a.refreshGroupList(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionManageActivity a;

        public b(EmotionManageActivity emotionManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionManageActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            h hVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (this.a.isSelectMode) {
                    if (this.a.mGroups.get(i) == null || (hVar = (h) view2.getTag()) == null) {
                        return;
                    }
                    Object tag = hVar.a.getTag();
                    if (tag instanceof String) {
                        String str = (String) tag;
                        for (f fVar : this.a.mGroups) {
                            if (fVar.a.equals(str)) {
                                if (this.a.mDelList.contains(str)) {
                                    SkinManager.setImageResource(hVar.a, R.drawable.btn_expression_choose_n);
                                    this.a.mDelList.remove(str);
                                    this.a.removeDel(str);
                                    fVar.c = false;
                                } else {
                                    SkinManager.setImageResource(hVar.a, R.drawable.btn_expression_choose_s);
                                    this.a.addDel(str);
                                    fVar.c = true;
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                this.a.sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.a.getPageContext().getPageActivity(), ((f) this.a.mGroups.get(i)).a, false, EmotionManageActivity.ST_TYPE)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionManageActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(EmotionManageActivity emotionManageActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.mQueryTask = new g(this.a, null);
                this.a.mQueryTask.execute(new String[0]);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = 0;
                List<String> list = listArr[0];
                if (list != null && !list.isEmpty()) {
                    for (String str : list) {
                        MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
                        myEmotionGroupData.setGroupId(str);
                        myEmotionGroupData.setUid(TbadkCoreApplication.getCurrentAccount());
                        if (y86.c().b(myEmotionGroupData)) {
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
                    this.a.isSelectMode = true;
                    this.a.refreshGroupList(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionManageActivity a;

        public e(EmotionManageActivity emotionManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionManageActivity;
        }

        public final View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = View.inflate(this.a.getPageContext().getPageActivity(), R.layout.obfuscated_res_0x7f0d0263, null);
                h hVar = new h(null);
                hVar.a = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09088d);
                hVar.b = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09088c);
                hVar.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09088b);
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
                if (this.a.mGroups == null) {
                    return 0;
                }
                return this.a.mGroups.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (this.a.mGroups == null || i > this.a.mGroups.size()) {
                    return null;
                }
                return this.a.mGroups.get(i);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                if (this.a.mGroups == null || i > this.a.mGroups.size()) {
                    return 0L;
                }
                return i;
            }
            return invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    view2 = a();
                }
                h hVar = (h) view2.getTag();
                Bitmap bitmap = ((f) this.a.mGroups.get(i)).d;
                if (bitmap != null) {
                    hVar.b.setImageBitmap(bitmap);
                } else {
                    SkinManager.setImageResource(hVar.b, R.drawable.pic_image_h_not);
                }
                if (this.a.isSelectMode) {
                    if (this.a.mDelList.contains(((f) this.a.mGroups.get(i)).a)) {
                        SkinManager.setImageResource(hVar.a, R.drawable.btn_expression_choose_s);
                    } else {
                        SkinManager.setImageResource(hVar.a, R.drawable.btn_expression_choose_n);
                    }
                    hVar.a.setVisibility(0);
                    hVar.a.setTag(((f) this.a.mGroups.get(i)).a);
                } else {
                    hVar.a.setVisibility(8);
                }
                hVar.c.setText(((f) this.a.mGroups.get(i)).b);
                this.a.getLayoutMode().j(view2);
                return view2;
            }
            return (View) invokeILL.objValue;
        }

        public /* synthetic */ e(EmotionManageActivity emotionManageActivity, a aVar) {
            this(emotionManageActivity);
        }
    }

    /* loaded from: classes3.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public boolean c;
        public Bitmap d;
        public final /* synthetic */ EmotionManageActivity e;

        public f(EmotionManageActivity emotionManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = emotionManageActivity;
        }

        public /* synthetic */ f(EmotionManageActivity emotionManageActivity, a aVar) {
            this(emotionManageActivity);
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                List<MyEmotionGroupData> h = y86.c().h(TbadkCoreApplication.getCurrentAccount());
                List<EmotionGroupData> l = e96.k().l(1);
                LinkedList linkedList = new LinkedList();
                for (MyEmotionGroupData myEmotionGroupData : h) {
                    Iterator<EmotionGroupData> it = l.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            EmotionGroupData next = it.next();
                            if (myEmotionGroupData.getGroupId().equals(next.getGroupId()) && z86.d(next.getGroupId())) {
                                f fVar = new f(this.a, null);
                                fVar.a = next.getGroupId();
                                fVar.b = next.getGroupName();
                                fVar.d = z86.f(fVar.a, "list.png");
                                linkedList.add(fVar);
                                break;
                            }
                        }
                    }
                }
                h.clear();
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
                this.a.mGroups = list;
                this.a.refreshGroupList(false);
                this.a.hideProgressBar();
                this.a.refreshTitle();
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

    /* loaded from: classes3.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;
        public ImageView b;
        public TextView c;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDelList = new LinkedList();
        this.isSelectMode = false;
        this.mOnClickListener = new a(this);
        this.mOnItemClickListener = new b(this);
        this.mListener = new c(this, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDel(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, this, str) == null) || this.mDelList.contains(str)) {
            return;
        }
        this.mDelList.add(str);
        refreshDel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeTitleToNormal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            this.mBack.setVisibility(0);
            this.mDel.setVisibility(8);
            this.mEdit.setText(getString(R.string.obfuscated_res_0x7f0f0513));
            this.isSelectMode = false;
            this.mFooter.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeTitleToSelection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            this.mBack.setVisibility(8);
            this.mDel.setVisibility(0);
            refreshDel();
            this.mEdit.setText(getString(R.string.obfuscated_res_0x7f0f036e));
            this.isSelectMode = true;
            this.mFooter.setVisibility(8);
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            registerListener(2001117, this.mListener);
            g gVar = new g(this, null);
            this.mQueryTask = gVar;
            gVar.execute(new String[0]);
            e eVar = new e(this, null);
            this.mAdapter = eVar;
            this.mGroupList.setAdapter((ListAdapter) eVar);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            this.mRoot = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0908a0);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923ac);
            this.mTitleBar = navigationBar;
            navigationBar.setTitleText(R.string.obfuscated_res_0x7f0f13ee);
            this.mBack = this.mTitleBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            NavigationBar navigationBar2 = this.mTitleBar;
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_LEFT;
            this.mDel = navigationBar2.addTextButton(controlAlign, getString(R.string.obfuscated_res_0x7f0f0495) + "(" + this.mDelList.size() + SmallTailInfo.EMOTION_SUFFIX, this.mOnClickListener, true);
            refreshDel();
            TextView addTextButton = this.mTitleBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.obfuscated_res_0x7f0f0513), this.mOnClickListener);
            this.mEdit = addTextButton;
            SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0106, 1);
            this.mNotice = (TextView) findViewById(R.id.obfuscated_res_0x7f0908a8);
            this.mListUpLine = (ImageView) findViewById(R.id.obfuscated_res_0x7f090897);
            BdListView bdListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f09089f);
            this.mGroupList = bdListView;
            bdListView.setOnItemClickListener(this.mOnItemClickListener);
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0262, (ViewGroup) null);
            this.mFooter = inflate;
            this.mGroupList.addFooterView(inflate);
            TextView textView = (TextView) this.mFooter.findViewById(R.id.obfuscated_res_0x7f090898);
            this.mEnterRecord = textView;
            textView.setOnClickListener(this.mOnClickListener);
            getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            getLayoutMode().j(this.mRoot);
            getLayoutMode().j(this.mFooter);
            changeTitleToNormal();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void refreshDel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            int size = this.mDelList.size();
            TextView textView = this.mDel;
            textView.setText(getString(R.string.obfuscated_res_0x7f0f0495) + "(" + size + SmallTailInfo.EMOTION_SUFFIX);
            if (size == 0) {
                this.mDel.setEnabled(false);
            } else {
                this.mDel.setEnabled(true);
            }
            SkinManager.setBackgroundResource(this.mDel, R.drawable.btn_delete_groupupdates);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshGroupList(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65561, this, z) == null) {
            if (z) {
                this.mDelList.clear();
            } else {
                for (String str : this.mDelList) {
                    boolean z2 = false;
                    Iterator<f> it = this.mGroups.iterator();
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
                        this.mDelList.remove(str);
                    }
                }
            }
            refreshDel();
            refreshTitle();
            this.mAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshTitle() {
        List<f> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || (list = this.mGroups) == null) {
            return;
        }
        if (list.size() == 0) {
            this.mNotice.setText(R.string.obfuscated_res_0x7f0f0550);
            this.mEdit.setEnabled(false);
            this.mListUpLine.setVisibility(8);
            changeTitleToNormal();
            return;
        }
        this.mNotice.setText(R.string.obfuscated_res_0x7f0f054f);
        this.mEdit.setEnabled(true);
        this.mListUpLine.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, str) == null) {
            this.mDelList.remove(str);
            refreshDel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDelete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            d dVar = new d(this, null);
            this.mDelTask = dVar;
            dVar.execute(this.mDelList);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.isSelectMode) {
                changeTitleToNormal();
                this.mDelList.clear();
                this.isSelectMode = false;
                this.mAdapter.notifyDataSetChanged();
                return;
            }
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.mTitleBar.onChangeSkinType(getPageContext(), i);
            SkinManager.setBackgroundResource(this.mDel, R.drawable.btn_delete_groupupdates);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0035);
            initView();
            initData();
            refreshGroupList(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            d dVar = this.mDelTask;
            if (dVar != null) {
                dVar.cancel(true);
                this.mDelTask = null;
            }
        }
    }
}
