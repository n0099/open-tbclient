package com.baidu.tieba;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.RenderMode;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.album.AddMediaInfo;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e2a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<MediaFileInfo> a;
    public BaseFragmentActivity b;
    public LayoutInflater c;
    public y1a d;
    public boolean e;
    public boolean f;
    public boolean g;
    public View.OnClickListener h;
    public c2a i;
    public d2a j;
    public TbCameraView.f k;
    public TbCameraView.d l;
    public bk6 m;
    public d n;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
            }
        }

        public a(e2a e2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e2a a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public b(e2a e2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e2aVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.n.d.cancelAnimation();
                this.a.n.d.setFrame(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e2a a;

        public c(e2a e2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e2aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m.d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public View b;
        public TbCameraView c;
        public TBLottieAnimationView d;

        public d(e2a e2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(e2a e2aVar, a aVar) {
            this(e2aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MediaFileInfo a;
        public int b;
        public final /* synthetic */ e2a c;

        public e(e2a e2aVar, MediaFileInfo mediaFileInfo, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2aVar, mediaFileInfo, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = e2aVar;
            this.a = mediaFileInfo;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091b4e) {
                    if (this.c.i != null && this.a != null) {
                        this.c.i.a(this.b, this.a);
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0913d5) {
                    if (this.a != null && this.c.j != null) {
                        this.c.j.a(this.b, this.a);
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092789 && this.c.j != null && this.a != null) {
                    this.c.j.a(this.b, this.a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TbImageView b;
        public TextView c;

        public f(e2a e2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(e2a e2aVar, a aVar) {
            this(e2aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TbImageView b;
        public ImageView c;
        public RelativeLayout d;

        public g(e2a e2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(e2a e2aVar, a aVar) {
            this(e2aVar);
        }
    }

    public e2a(BaseFragmentActivity baseFragmentActivity, y1a y1aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, y1aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.e = false;
        this.f = true;
        this.g = true;
        this.b = baseFragmentActivity;
        this.d = y1aVar;
        this.c = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
    }

    public void u(ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048598, this, imageView, z) == null) && imageView != null) {
            if (z) {
                imageView.setContentDescription(TbadkCoreApplication.getInst().getString(R.string.check_box_checked));
                imageView.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_set_list_ok_selection26, WebPManager.ResourceStateType.NORMAL));
                return;
            }
            imageView.setContentDescription(TbadkCoreApplication.getInst().getString(R.string.check_box_not_checked));
            imageView.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080878, WebPManager.ResourceStateType.NORMAL));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: e */
    public MediaFileInfo getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return (MediaFileInfo) ListUtils.getItem(this.a, i);
        }
        return (MediaFileInfo) invokeI.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            MediaFileInfo mediaFileInfo = (MediaFileInfo) ListUtils.getItem(this.a, i);
            if (mediaFileInfo != null) {
                return mediaFileInfo.getType();
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public void n(List<MediaFileInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.a.clear();
            if (this.f) {
                this.a.add(l());
            }
            if (!ListUtils.isEmpty(list)) {
                this.a.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public void o(c2a c2aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, c2aVar) == null) {
            this.i = c2aVar;
        }
    }

    public void p(TbCameraView.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
            this.l = dVar;
        }
    }

    public void q(TbCameraView.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, fVar) == null) {
            this.k = fVar;
        }
    }

    public void r(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            this.h = onClickListener;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.e = z;
        }
    }

    public void v(d2a d2aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, d2aVar) == null) {
            this.j = d2aVar;
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048600, this, z) == null) && this.f != z) {
            this.f = z;
            notifyDataSetChanged();
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.g = z;
        }
    }

    public final View f(int i, View view2, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mediaFileInfo})) == null) {
            if (mediaFileInfo != null && mediaFileInfo.getType() == 2) {
                d dVar = this.n;
                if (dVar == null || dVar.c == null) {
                    this.n = new d(this, null);
                    View inflate = this.c.inflate(R.layout.obfuscated_res_0x7f0d011d, viewGroup, false);
                    d dVar2 = this.n;
                    dVar2.a = inflate;
                    dVar2.c = (TbCameraView) inflate.findViewById(R.id.obfuscated_res_0x7f090508);
                    this.n.d = (TBLottieAnimationView) inflate.findViewById(R.id.obfuscated_res_0x7f090280);
                    this.n.b = inflate.findViewById(R.id.obfuscated_res_0x7f090f77);
                    this.n.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.n.d.setFrame(0);
                    this.n.d.setRenderMode(RenderMode.HARDWARE);
                    SkinManager.setLottieAnimation(this.n.d, R.raw.lottie_photo);
                    inflate.setTag(this.n);
                    y(this.n.b);
                }
                SkinManager.setBackgroundColor(this.n.a, R.color.black_alpha90);
                this.n.c.setOnRequestPermissionListener(this.k);
                this.n.c.setOnOpenCameraFailedListener(this.l);
                this.n.d.setOnClickListener(this.h);
                this.n.c.setOnClickListener(this.h);
                this.n.a.setOnClickListener(this.h);
                this.n.d.addAnimatorUpdateListener(new a(this));
                this.n.d.addAnimatorListener(new b(this));
                return this.n.a;
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final View g(int i, View view2, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        InterceptResult invokeCommon;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mediaFileInfo})) == null) {
            if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
                if (view2 != null && (view2.getTag() instanceof g)) {
                    gVar = (g) view2.getTag();
                } else {
                    g gVar2 = new g(this, null);
                    View inflate = this.c.inflate(R.layout.obfuscated_res_0x7f0d011a, viewGroup, false);
                    gVar2.a = inflate;
                    TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091b4e);
                    gVar2.b = tbImageView;
                    tbImageView.setDefaultResource(0);
                    gVar2.b.setTagPaddingDis(8, 8);
                    gVar2.b.setGifIconSupport(true);
                    gVar2.b.setLongIconSupport(true);
                    gVar2.c = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091ff3);
                    gVar2.d = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0913d5);
                    y1a y1aVar = this.d;
                    if (y1aVar != null && y1aVar.m() != null && this.d.m().isFromQRCode()) {
                        gVar2.d.setVisibility(8);
                    }
                    if (!this.g) {
                        gVar2.d.setVisibility(8);
                    }
                    inflate.setTag(gVar2);
                    gVar = gVar2;
                    view2 = inflate;
                }
                gVar.b.setIsLongPic(imageFileInfo.isLong());
                gVar.b.N(imageFileInfo.getFilePath(), 35, false);
                t(gVar.c, mediaFileInfo);
                e eVar = new e(this, mediaFileInfo, i);
                gVar.b.setOnClickListener(eVar);
                gVar.d.setOnClickListener(eVar);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ListUtils.getCount(this.a);
        }
        return invokeV.intValue;
    }

    public TbCameraView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d dVar = this.n;
            if (dVar != null) {
                return dVar.c;
            }
            return null;
        }
        return (TbCameraView) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public final MediaFileInfo l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return new AddMediaInfo();
        }
        return (MediaFileInfo) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            bk6 bk6Var = this.m;
            if (bk6Var != null) {
                bk6Var.d();
            }
            this.i = null;
            this.b = null;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            MediaFileInfo item = getItem(i);
            if (item == null) {
                return view2;
            }
            if (item.getType() == 2) {
                return f(i, view2, viewGroup, item);
            }
            if (item.getType() == 1) {
                return h(i, view2, viewGroup, item);
            }
            if (item.getType() == 0) {
                return g(i, view2, viewGroup, item);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final View h(int i, View view2, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        InterceptResult invokeCommon;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mediaFileInfo})) == null) {
            if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
                VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
                if (view2 != null && (view2.getTag() instanceof g)) {
                    fVar = (f) view2.getTag();
                } else {
                    f fVar2 = new f(this, null);
                    View inflate = this.c.inflate(R.layout.obfuscated_res_0x7f0d011e, viewGroup, false);
                    fVar2.a = inflate;
                    TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092789);
                    fVar2.b = tbImageView;
                    tbImageView.setDefaultResource(0);
                    fVar2.b.setTagPaddingDis(8, 8);
                    fVar2.b.setGifIconSupport(false);
                    fVar2.b.setLongIconSupport(false);
                    fVar2.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09275f);
                    inflate.setTag(fVar2);
                    fVar = fVar2;
                    view2 = inflate;
                }
                fVar.b.N(videoFileInfo.videoPath, 37, false);
                fVar.c.setText(StringHelper.stringForVideoTime(videoFileInfo.videoDuration));
                fVar.b.setOnClickListener(new e(this, mediaFileInfo, i));
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public int i(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        List<MediaFileInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, imageFileInfo)) == null) {
            if (imageFileInfo != null && imageFileInfo.getFilePath() != null && (list = this.a) != null && list.size() != 0) {
                String filePath = imageFileInfo.getFilePath();
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    MediaFileInfo mediaFileInfo = this.a.get(i);
                    if (mediaFileInfo instanceof ImageFileInfo) {
                        ImageFileInfo imageFileInfo2 = (ImageFileInfo) mediaFileInfo;
                        if (imageFileInfo2.getFilePath() != null && imageFileInfo2.getFilePath().equals(filePath)) {
                            return i;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void y(View view2) {
        BaseFragmentActivity baseFragmentActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view2) == null) {
            if (this.m == null && view2 != null && (baseFragmentActivity = this.b) != null) {
                bk6 bk6Var = new bk6(baseFragmentActivity.getPageContext(), view2);
                this.m = bk6Var;
                bk6Var.C(R.drawable.bg_tip_blue_up_left);
                this.m.i(new c(this));
                this.m.k(16);
                this.m.j(5000);
            }
            if (this.m != null) {
                this.m.K(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0265), q45.q("key_show_take_photo_tip"));
            }
        }
    }

    public final void t(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, imageView, mediaFileInfo) == null) {
            y1a y1aVar = this.d;
            if (y1aVar != null && (mediaFileInfo instanceof ImageFileInfo)) {
                z = y1aVar.n((ImageFileInfo) mediaFileInfo);
            } else {
                y1a y1aVar2 = this.d;
                if (y1aVar2 != null && (mediaFileInfo instanceof VideoFileInfo)) {
                    z = y1aVar2.q((VideoFileInfo) mediaFileInfo);
                } else {
                    z = false;
                }
            }
            u(imageView, z);
        }
    }
}
