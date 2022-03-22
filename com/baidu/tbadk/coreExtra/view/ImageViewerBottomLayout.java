package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.r.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageUrlData a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f30403b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f30404c;

    /* renamed from: d  reason: collision with root package name */
    public View f30405d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f30406e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f30407f;

    /* renamed from: g  reason: collision with root package name */
    public AgreeView f30408g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f30409h;
    public TextView i;
    public ImageView j;
    public ImageView k;
    public String l;
    public a m;
    public c n;
    public b o;
    public Context p;
    public boolean q;

    /* loaded from: classes5.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onSave();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1510753250, "Lcom/baidu/tbadk/coreExtra/view/ImageViewerBottomLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1510753250, "Lcom/baidu/tbadk/coreExtra/view/ImageViewerBottomLayout;");
                return;
            }
        }
        r = n.f(TbadkApplication.getInst(), R.dimen.tbds130);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewerBottomLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = context;
        a(context);
        b();
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d03d8, (ViewGroup) this, true);
            this.f30405d = findViewById(R.id.obfuscated_res_0x7f09226a);
            this.f30403b = (TextView) findViewById(R.id.obfuscated_res_0x7f09226b);
            this.f30404c = (ImageView) findViewById(R.id.obfuscated_res_0x7f092269);
            this.f30405d.setVisibility(8);
            WebPManager.setMaskDrawable(this.f30404c, R.drawable.obfuscated_res_0x7f08082a, null);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090e89);
            this.f30406e = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f08b4);
            SkinManager.setViewTextColor(this.f30406e, (int) R.color.CAM_X0101);
            this.f30406e.setBackground(SkinManager.createShapeDrawableFromColor(n.f(context, R.dimen.tbds38), SkinManager.getColor(R.color.CAM_X0615)));
            this.f30407f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090e88);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09068b);
            this.f30409h = imageView;
            WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f0808e9, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f09068e);
            this.i = textView2;
            textView2.setText("0");
            AgreeView agreeView = (AgreeView) findViewById(R.id.obfuscated_res_0x7f09014d);
            this.f30408g = agreeView;
            agreeView.setResourceId(R.raw.obfuscated_res_0x7f11001b, R.raw.obfuscated_res_0x7f110028);
            this.f30408g.setIsFromBigpic(true);
            this.f30408g.setAgreeAlone(true);
            this.f30408g.setAgreeAnimationResource();
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.f30408g.getImgAgree().setAlpha(0.83f);
            } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.f30408g.getImgAgree().setAlpha(0.92f);
            } else {
                this.f30408g.getImgAgree().setAlpha(1.0f);
            }
            f fVar = new f();
            fVar.f10852b = 13;
            fVar.f10858h = 10;
            this.f30408g.setStatisticData(fVar);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cbd);
            this.j = imageView2;
            WebPManager.setPureDrawable(imageView2, R.drawable.obfuscated_res_0x7f0808fe, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            ImageView imageView3 = (ImageView) findViewById(R.id.obfuscated_res_0x7f09081b);
            this.k = imageView3;
            WebPManager.setPureDrawable(imageView3, R.drawable.obfuscated_res_0x7f080987, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f30409h.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.f30405d.setOnClickListener(this);
            setOnTouchListener(this);
        }
    }

    public final void c() {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (imageUrlData = this.a) == null) {
            return;
        }
        String valueOf = String.valueOf(imageUrlData.threadId);
        String valueOf2 = String.valueOf(this.a.postId);
        PbActivityConfig pbActivityConfig = new PbActivityConfig(getContext());
        ImageUrlData imageUrlData2 = this.a;
        PbActivityConfig createHistoryCfg = pbActivityConfig.createHistoryCfg(valueOf, valueOf2, imageUrlData2.mIsSeeHost, imageUrlData2.mIsReserver, null);
        createHistoryCfg.setJumpToCommentArea(true);
        createHistoryCfg.setHighLightPostId(valueOf2);
        createHistoryCfg.setStartFrom(23);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createHistoryCfg));
    }

    public void d(ImageUrlData imageUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, imageUrlData) == null) {
            this.a = imageUrlData;
            if (imageUrlData != null && imageUrlData.agreeData != null) {
                setVisibility(0);
                String str = imageUrlData.commentNum;
                if (str != null) {
                    this.i.setText(str);
                }
                AgreeData agreeData = imageUrlData.agreeData;
                if (agreeData != null) {
                    this.f30408g.setData(agreeData);
                }
                if (this.q) {
                    return;
                }
                this.f30405d.setVisibility(0);
                return;
            }
            setVisibility(8);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.f30403b.setText(getContext().getString(R.string.obfuscated_res_0x7f0f05ba));
                WebPManager.setMaskDrawable(this.f30404c, R.drawable.obfuscated_res_0x7f0807da, null);
                this.f30407f.setVisibility(8);
                this.f30406e.setVisibility(8);
                return;
            }
            this.f30403b.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0620));
            WebPManager.setMaskDrawable(this.f30404c, R.drawable.obfuscated_res_0x7f08082a, null);
            this.f30407f.setVisibility(0);
            this.f30406e.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (view != this.f30409h && view != this.i) {
                if (view == this.j) {
                    c cVar = this.n;
                    if (cVar != null) {
                        cVar.a();
                    }
                    if (this.a != null) {
                        TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "9").param("post_id", this.a.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.forumId));
                        return;
                    }
                    return;
                } else if (view == this.k) {
                    b bVar = this.o;
                    if (bVar != null) {
                        bVar.onSave();
                    }
                    if (this.a != null) {
                        TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "2").param("post_id", this.a.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.forumId));
                        return;
                    }
                    return;
                } else if (view == this.f30405d) {
                    if (this.f30403b.getText().toString().equals(getContext().getString(R.string.obfuscated_res_0x7f0f05ba))) {
                        this.f30403b.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0620));
                        WebPManager.setMaskDrawable(this.f30404c, R.drawable.obfuscated_res_0x7f08082a, null);
                        a aVar = this.m;
                        if (aVar != null) {
                            aVar.a(this, true);
                        }
                    } else {
                        this.f30403b.setText(getContext().getString(R.string.obfuscated_res_0x7f0f05ba));
                        WebPManager.setMaskDrawable(this.f30404c, R.drawable.obfuscated_res_0x7f0807da, null);
                        a aVar2 = this.m;
                        if (aVar2 != null) {
                            aVar2.a(this, false);
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "6").param("post_id", this.a.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.forumId));
                    return;
                } else {
                    return;
                }
            }
            if (this.a != null) {
                StatisticItem statisticItem = new StatisticItem("c13685");
                statisticItem.param("tid", this.a.threadId);
                statisticItem.param("nid", this.a.nid);
                statisticItem.param("fid", this.a.forumId);
                String str = this.a.from;
                if (str == "index") {
                    statisticItem.param("obj_locate", 1);
                } else if (str == "frs") {
                    statisticItem.param("obj_locate", 2);
                } else if (str == "pb") {
                    statisticItem.param("obj_locate", 3);
                }
                TiebaStatic.log(statisticItem);
            }
            c.a.o0.n0.c findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view);
            StatisticItem statisticItem2 = new StatisticItem("c12942");
            statisticItem2.param("obj_type", "2");
            statisticItem2.param("obj_locate", "12");
            if (findPageExtraByView != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(statisticItem2);
            c();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view, motionEvent)) == null) {
            TiebaStatic.log(new StatisticItem("c13339").param("uid", this.l).param("post_id", this.a.threadId));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void setExpandButtonListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.m = aVar;
        }
    }

    public void setOnDownloadImageListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.o = bVar;
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.f30406e.setOnClickListener(onClickListener);
        }
    }

    public void setOnShareImageListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.n = cVar;
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.l = str;
        }
    }

    public void setYoungterCoverSomeView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.q = false;
            this.f30406e.setVisibility(z ? 8 : 0);
            this.f30409h.setVisibility(z ? 8 : 0);
            this.i.setVisibility(z ? 8 : 0);
            this.f30408g.setVisibility(z ? 8 : 0);
            this.j.setVisibility(z ? 8 : 0);
        }
    }
}
