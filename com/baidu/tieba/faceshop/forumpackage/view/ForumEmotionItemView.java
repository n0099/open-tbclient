package com.baidu.tieba.faceshop.forumpackage.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ForumEmotionItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HListView f15225e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15226f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15227g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15228h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f15229i;
    public TextView j;
    public View k;
    public View l;
    public TextView m;
    public ViewGroup n;
    public TextView o;
    public a p;
    public TbPageContext q;

    /* loaded from: classes4.dex */
    public static class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f15230e;

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext f15231f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f15232g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f15233h;

        /* renamed from: com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0196a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public View f15234a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f15235b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f15236c;

            /* renamed from: d  reason: collision with root package name */
            public View f15237d;

            public C0196a(View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15234a = view;
                view.setEnabled(false);
                this.f15235b = (TbImageView) this.f15234a.findViewById(R.id.emotion_img);
                this.f15236c = (TextView) this.f15234a.findViewById(R.id.emotion_single_bar_icon);
                View findViewById = this.f15234a.findViewById(R.id.emotion_cover_view);
                this.f15237d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{singleEmotionData, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f15235b.setDefaultResource(R.drawable.img_default_100);
                    this.f15235b.M(singleEmotionData.thumbnail, 10, false);
                }
                if (z) {
                    this.f15236c.setVisibility(0);
                } else {
                    this.f15236c.setVisibility(8);
                }
                if (i2 == 7 && z2) {
                    this.f15237d.setVisibility(0);
                } else {
                    this.f15237d.setVisibility(8);
                }
            }
        }

        public a(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15230e = new ArrayList();
            this.f15232g = false;
            this.f15233h = false;
            this.f15231f = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f15232g = z;
            if (list.size() > 8) {
                this.f15230e = list.subList(0, 8);
                this.f15233h = true;
            } else {
                this.f15230e = list;
                this.f15233h = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.f15230e;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.f15230e;
                if (list == null) {
                    return null;
                }
                return list.get(i2);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            C0196a c0196a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    view = LayoutInflater.from(this.f15231f.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                    c0196a = new C0196a(view);
                    view.setTag(c0196a);
                } else {
                    c0196a = (C0196a) view.getTag();
                }
                c0196a.a(this.f15230e.get(i2), i2 == 0 && this.f15232g, this.f15233h, i2);
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEmotionItemView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = tbPageContext;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.forum_emotion_list_item_layout, this);
            this.f15225e = (HListView) findViewById(R.id.forum_emotion_item_list);
            this.l = findViewById(R.id.forum_emotion_list_head);
            this.m = (TextView) findViewById(R.id.forum_emotion_filter);
            this.n = (ViewGroup) findViewById(R.id.forum_emotion_filter_dropdown);
            this.j = (TextView) findViewById(R.id.forum_emotion_rank);
            this.f15226f = (TextView) findViewById(R.id.forum_emotion_title_tv);
            this.f15227g = (TextView) findViewById(R.id.forum_emotion_download_num_tv);
            this.f15228h = (TextView) findViewById(R.id.forum_emotion_share_num_tv);
            this.f15229i = (TextView) findViewById(R.id.forum_emotion_download_tv);
            this.k = findViewById(R.id.line);
            this.o = (TextView) findViewById(R.id.forum_emotion_board_title);
            this.f15225e.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
            this.f15225e.setSelector(this.q.getResources().getDrawable(R.drawable.transparent_bg));
            a aVar = new a(this.q);
            this.p = aVar;
            this.f15225e.setAdapter((ListAdapter) aVar);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setViewTextColor(this.f15226f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f15227g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f15228h, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f15229i, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n.getChildAt(0), R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.n.getChildAt(0), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.n.getChildAt(1), R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.n.getChildAt(1), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107);
        }
    }

    public a getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p : (a) invokeV.objValue;
    }

    public TextView getDownLoadView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15229i : (TextView) invokeV.objValue;
    }

    public TextView getDownloadNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15227g : (TextView) invokeV.objValue;
    }

    public ViewGroup getFilterDropDownView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : (ViewGroup) invokeV.objValue;
    }

    public TextView getFilterView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m : (TextView) invokeV.objValue;
    }

    public View getHeaderView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public View getLineView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public HListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f15225e : (HListView) invokeV.objValue;
    }

    public TextView getRankView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.j : (TextView) invokeV.objValue;
    }

    public TextView getShareNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f15228h : (TextView) invokeV.objValue;
    }

    public TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f15226f : (TextView) invokeV.objValue;
    }
}
