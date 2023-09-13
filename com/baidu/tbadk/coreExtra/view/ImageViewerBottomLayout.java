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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.h15;
import com.baidu.tieba.ms5;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageUrlData a;
    public TextView b;
    public ImageView c;
    public View d;
    public TextView e;
    public LinearLayout f;
    public AgreeView g;
    public ImageView h;
    public TextView i;
    public ImageView j;
    public ImageView k;
    public String l;
    public a m;
    public c n;
    public b o;
    public Context p;
    public boolean q;

    /* loaded from: classes4.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void k();
    }

    /* loaded from: classes4.dex */
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
        r = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.h.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.d.setOnClickListener(this);
            setOnTouchListener(this);
        }
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
            LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
            this.d = findViewById(R.id.unfold_root);
            this.b = (TextView) findViewById(R.id.unfold_text);
            this.c = (ImageView) findViewById(R.id.unfold_icon);
            this.d.setVisibility(8);
            WebPManager.setMaskDrawable(this.c, R.drawable.icon_mask_unfold30, null);
            TextView textView = (TextView) findViewById(R.id.image_viewer_reply);
            this.e = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f1247);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
            this.e.setBackground(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(context, R.dimen.tbds38), SkinManager.getColor(R.color.CAM_X0615)));
            this.f = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
            ImageView imageView = (ImageView) findViewById(R.id.comment_icon);
            this.h = imageView;
            WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_card_comment22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            TextView textView2 = (TextView) findViewById(R.id.comment_num);
            this.i = textView2;
            textView2.setText("0");
            AgreeView agreeView = (AgreeView) findViewById(R.id.agree_and_disagreeview);
            this.g = agreeView;
            agreeView.setResourceId(R.raw.lottie_agree_imageviewer, R.raw.lottie_disagree_imageviewer);
            this.g.setIsFromBigpic(true);
            this.g.setAgreeAlone(true);
            this.g.setAgreeAnimationResource();
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.g.getImgAgree().setAlpha(0.92f);
            } else {
                this.g.getImgAgree().setAlpha(1.0f);
            }
            h15 h15Var = new h15();
            h15Var.b = 13;
            h15Var.h = 10;
            this.g.setStatisticData(h15Var);
            ImageView imageView2 = (ImageView) findViewById(R.id.share_icon);
            this.j = imageView2;
            WebPManager.setPureDrawable(imageView2, R.drawable.icon_pure_expression22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            ImageView imageView3 = (ImageView) findViewById(R.id.download_icon);
            this.k = imageView3;
            WebPManager.setPureDrawable(imageView3, R.drawable.icon_pure_share_download22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        }
    }

    public final void c() {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (imageUrlData = this.a) == null) {
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
                    this.g.setData(agreeData);
                }
                if (!this.q) {
                    this.d.setVisibility(0);
                }
                ImageView imageView = this.j;
                if (imageView != null) {
                    WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_expression22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
                    return;
                }
                return;
            }
            setVisibility(8);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.b.setText(getContext().getString(R.string.obfuscated_res_0x7f0f06ed));
                WebPManager.setMaskDrawable(this.c, R.drawable.icon_mask_fold30, null);
                this.f.setVisibility(8);
                this.e.setVisibility(8);
                return;
            }
            this.b.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0760));
            WebPManager.setMaskDrawable(this.c, R.drawable.icon_mask_unfold30, null);
            this.f.setVisibility(0);
            this.e.setVisibility(0);
        }
    }

    public void setYoungterCoverSomeView(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            int i5 = 0;
            this.q = false;
            TextView textView = this.e;
            if (z) {
                i = 8;
            } else {
                i = 0;
            }
            textView.setVisibility(i);
            ImageView imageView = this.h;
            if (z) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            TextView textView2 = this.i;
            if (z) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            textView2.setVisibility(i3);
            AgreeView agreeView = this.g;
            if (z) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            agreeView.setVisibility(i4);
            ImageView imageView2 = this.j;
            if (z) {
                i5 = 8;
            }
            imageView2.setVisibility(i5);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (view2 != this.h && view2 != this.i) {
                if (view2 == this.j) {
                    c cVar = this.n;
                    if (cVar != null) {
                        cVar.a();
                    }
                    if (this.a != null) {
                        TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "9").param("post_id", this.a.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.forumId));
                        return;
                    }
                    return;
                } else if (view2 == this.k) {
                    b bVar = this.o;
                    if (bVar != null) {
                        bVar.k();
                    }
                    if (this.a != null) {
                        TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "2").param("post_id", this.a.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.forumId));
                        return;
                    }
                    return;
                } else if (view2 == this.d) {
                    if (this.b.getText().toString().equals(getContext().getString(R.string.obfuscated_res_0x7f0f06ed))) {
                        this.b.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0760));
                        WebPManager.setMaskDrawable(this.c, R.drawable.icon_mask_unfold30, null);
                        a aVar = this.m;
                        if (aVar != null) {
                            aVar.a(this, true);
                        }
                    } else {
                        this.b.setText(getContext().getString(R.string.obfuscated_res_0x7f0f06ed));
                        WebPManager.setMaskDrawable(this.c, R.drawable.icon_mask_fold30, null);
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
                if ("index".equals(str)) {
                    statisticItem.param("obj_locate", 1);
                } else if ("frs".equals(str)) {
                    statisticItem.param("obj_locate", 2);
                } else if ("pb".equals(str)) {
                    statisticItem.param("obj_locate", 3);
                } else if (GlobalBuildConfig.isDebug()) {
                    Context context = getContext();
                    BdToast.makeText(context, "Debug 弹窗：c13685点位obj_locate未命中 from = " + str).show();
                }
                TiebaStatic.log(statisticItem);
            }
            ms5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view2, motionEvent)) == null) {
            TiebaStatic.log(new StatisticItem("c13339").param("uid", this.l).param("post_id", this.a.threadId));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void setCommentVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.h.setVisibility(i);
            this.i.setVisibility(i);
        }
    }

    public void setExpandButtonListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.m = aVar;
        }
    }

    public void setOnDownloadImageListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.o = bVar;
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.e.setOnClickListener(onClickListener);
        }
    }

    public void setOnShareImageListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.n = cVar;
        }
    }

    public void setRelayBtnVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.e.setVisibility(i);
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.l = str;
        }
    }
}
