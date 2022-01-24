package com.baidu.tieba.faceshop.forumpackage.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
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
/* loaded from: classes12.dex */
public class ForumEmotionItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HListView f43003e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f43004f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f43005g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f43006h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f43007i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f43008j;
    public View k;
    public View l;
    public TextView m;
    public ViewGroup n;
    public TextView o;
    public a p;
    public TbPageContext q;

    /* loaded from: classes12.dex */
    public static class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public List<EmotionPackageData.SingleEmotionData> f43009e;

        /* renamed from: f  reason: collision with root package name */
        public TbPageContext f43010f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f43011g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f43012h;

        /* renamed from: com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static class C1914a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public View a;

            /* renamed from: b  reason: collision with root package name */
            public TbImageView f43013b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f43014c;

            /* renamed from: d  reason: collision with root package name */
            public View f43015d;

            public C1914a(View view) {
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
                this.a = view;
                view.setEnabled(false);
                this.f43013b = (TbImageView) this.a.findViewById(R.id.emotion_img);
                this.f43014c = (TextView) this.a.findViewById(R.id.emotion_single_bar_icon);
                View findViewById = this.a.findViewById(R.id.emotion_cover_view);
                this.f43015d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{singleEmotionData, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.f43013b.setDefaultResource(R.drawable.img_default_100);
                    this.f43013b.startLoad(singleEmotionData.thumbnail, 10, false);
                }
                if (z) {
                    this.f43014c.setVisibility(0);
                } else {
                    this.f43014c.setVisibility(8);
                }
                if (i2 == 7 && z2) {
                    this.f43015d.setVisibility(0);
                } else {
                    this.f43015d.setVisibility(8);
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
            this.f43009e = new ArrayList();
            this.f43011g = false;
            this.f43012h = false;
            this.f43010f = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, list, z) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f43011g = z;
            if (list.size() > 8) {
                this.f43009e = list.subList(0, 8);
                this.f43012h = true;
            } else {
                this.f43009e = list;
                this.f43012h = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.f43009e;
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
                List<EmotionPackageData.SingleEmotionData> list = this.f43009e;
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
            C1914a c1914a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    view = LayoutInflater.from(this.f43010f.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                    c1914a = new C1914a(view);
                    view.setTag(c1914a);
                } else {
                    c1914a = (C1914a) view.getTag();
                }
                c1914a.a(this.f43009e.get(i2), i2 == 0 && this.f43011g, this.f43012h, i2);
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
            this.f43003e = (HListView) findViewById(R.id.forum_emotion_item_list);
            this.l = findViewById(R.id.forum_emotion_list_head);
            this.m = (TextView) findViewById(R.id.forum_emotion_filter);
            this.n = (ViewGroup) findViewById(R.id.forum_emotion_filter_dropdown);
            this.f43008j = (TextView) findViewById(R.id.forum_emotion_rank);
            this.f43004f = (TextView) findViewById(R.id.forum_emotion_title_tv);
            this.f43005g = (TextView) findViewById(R.id.forum_emotion_download_num_tv);
            this.f43006h = (TextView) findViewById(R.id.forum_emotion_share_num_tv);
            this.f43007i = (TextView) findViewById(R.id.forum_emotion_download_tv);
            this.k = findViewById(R.id.line);
            this.o = (TextView) findViewById(R.id.forum_emotion_board_title);
            this.f43003e.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
            this.f43003e.setSelector(this.q.getResources().getDrawable(R.drawable.transparent_bg));
            a aVar = new a(this.q);
            this.p = aVar;
            this.f43003e.setAdapter((ListAdapter) aVar);
        }
    }

    public a getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p : (a) invokeV.objValue;
    }

    public TextView getDownLoadView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f43007i : (TextView) invokeV.objValue;
    }

    public TextView getDownloadNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f43005g : (TextView) invokeV.objValue;
    }

    public ViewGroup getFilterDropDownView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : (ViewGroup) invokeV.objValue;
    }

    public TextView getFilterView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : (TextView) invokeV.objValue;
    }

    public View getHeaderView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public View getLineView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public HListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f43003e : (HListView) invokeV.objValue;
    }

    public TextView getRankView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f43008j : (TextView) invokeV.objValue;
    }

    public TextView getShareNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f43006h : (TextView) invokeV.objValue;
    }

    public TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f43004f : (TextView) invokeV.objValue;
    }

    public void onChangeSkin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            SkinManager.setViewTextColor(this.f43004f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f43005g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f43006h, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f43007i, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f43008j, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n.getChildAt(0), R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.n.getChildAt(0), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.n.getChildAt(1), R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.n.getChildAt(1), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEmotionItemView(TbPageContext tbPageContext, AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEmotionItemView(TbPageContext tbPageContext, AttributeSet attributeSet, int i2) {
        super(tbPageContext.getPageActivity(), attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a();
    }
}
