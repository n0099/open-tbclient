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
import c.a.q0.r.r.f;
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
    public static final int ImageViewerBottomHeight;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageUrlData f39485e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f39486f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f39487g;

    /* renamed from: h  reason: collision with root package name */
    public View f39488h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f39489i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f39490j;
    public AgreeView k;
    public ImageView l;
    public TextView m;
    public ImageView n;
    public ImageView o;
    public String p;
    public a q;
    public c r;
    public b s;
    public Context t;
    public boolean u;

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
        ImageViewerBottomHeight = n.f(TbadkApplication.getInst(), R.dimen.tbds130);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = context;
        a(context);
        b();
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
            this.f39488h = findViewById(R.id.unfold_root);
            this.f39486f = (TextView) findViewById(R.id.unfold_text);
            this.f39487g = (ImageView) findViewById(R.id.unfold_icon);
            this.f39488h.setVisibility(8);
            WebPManager.setMaskDrawable(this.f39487g, R.drawable.icon_mask_unfold30, null);
            TextView textView = (TextView) findViewById(R.id.image_viewer_reply);
            this.f39489i = textView;
            textView.setText(R.string.image_viewer_reply);
            SkinManager.setViewTextColor(this.f39489i, (int) R.color.CAM_X0101);
            this.f39489i.setBackground(SkinManager.createShapeDrawableFromColor(n.f(context, R.dimen.tbds38), SkinManager.getColor(R.color.CAM_X0615)));
            this.f39490j = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
            ImageView imageView = (ImageView) findViewById(R.id.comment_icon);
            this.l = imageView;
            WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_card_comment22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            TextView textView2 = (TextView) findViewById(R.id.comment_num);
            this.m = textView2;
            textView2.setText("0");
            AgreeView agreeView = (AgreeView) findViewById(R.id.agree_and_disagreeview);
            this.k = agreeView;
            agreeView.setResourceId(R.raw.lottie_agree_imageviewer, R.raw.lottie_disagree_imageviewer);
            this.k.setIsFromBigpic(true);
            this.k.setAgreeAlone(true);
            this.k.setAgreeAnimationResource();
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.k.getImgAgree().setAlpha(0.83f);
            } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.k.getImgAgree().setAlpha(0.92f);
            } else {
                this.k.getImgAgree().setAlpha(1.0f);
            }
            f fVar = new f();
            fVar.f13257b = 13;
            fVar.f13263h = 10;
            this.k.setStatisticData(fVar);
            ImageView imageView2 = (ImageView) findViewById(R.id.share_icon);
            this.n = imageView2;
            WebPManager.setPureDrawable(imageView2, R.drawable.icon_pure_expression22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            ImageView imageView3 = (ImageView) findViewById(R.id.download_icon);
            this.o = imageView3;
            WebPManager.setPureDrawable(imageView3, R.drawable.icon_pure_share_download22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.f39488h.setOnClickListener(this);
            setOnTouchListener(this);
        }
    }

    public final void d() {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (imageUrlData = this.f39485e) == null) {
            return;
        }
        String valueOf = String.valueOf(imageUrlData.threadId);
        String valueOf2 = String.valueOf(this.f39485e.postId);
        PbActivityConfig pbActivityConfig = new PbActivityConfig(getContext());
        ImageUrlData imageUrlData2 = this.f39485e;
        PbActivityConfig createHistoryCfg = pbActivityConfig.createHistoryCfg(valueOf, valueOf2, imageUrlData2.mIsSeeHost, imageUrlData2.mIsReserver, null);
        createHistoryCfg.setJumpToCommentArea(true);
        createHistoryCfg.setHighLightPostId(valueOf2);
        createHistoryCfg.setStartFrom(23);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createHistoryCfg));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view != this.l && view != this.m) {
                if (view == this.n) {
                    c cVar = this.r;
                    if (cVar != null) {
                        cVar.a();
                    }
                    if (this.f39485e != null) {
                        TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "9").param("post_id", this.f39485e.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f39485e.forumId));
                        return;
                    }
                    return;
                } else if (view == this.o) {
                    b bVar = this.s;
                    if (bVar != null) {
                        bVar.onSave();
                    }
                    if (this.f39485e != null) {
                        TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "2").param("post_id", this.f39485e.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f39485e.forumId));
                        return;
                    }
                    return;
                } else if (view == this.f39488h) {
                    if (this.f39486f.getText().toString().equals(getContext().getString(R.string.expand))) {
                        this.f39486f.setText(getContext().getString(R.string.fold));
                        WebPManager.setMaskDrawable(this.f39487g, R.drawable.icon_mask_unfold30, null);
                        a aVar = this.q;
                        if (aVar != null) {
                            aVar.a(this, true);
                        }
                    } else {
                        this.f39486f.setText(getContext().getString(R.string.expand));
                        WebPManager.setMaskDrawable(this.f39487g, R.drawable.icon_mask_fold30, null);
                        a aVar2 = this.q;
                        if (aVar2 != null) {
                            aVar2.a(this, false);
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "6").param("post_id", this.f39485e.threadId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f39485e.forumId));
                    return;
                } else {
                    return;
                }
            }
            if (this.f39485e != null) {
                StatisticItem statisticItem = new StatisticItem("c13685");
                statisticItem.param("tid", this.f39485e.threadId);
                statisticItem.param("nid", this.f39485e.nid);
                statisticItem.param("fid", this.f39485e.forumId);
                String str = this.f39485e.from;
                if (str == "index") {
                    statisticItem.param("obj_locate", 1);
                } else if (str == "frs") {
                    statisticItem.param("obj_locate", 2);
                } else if (str == "pb") {
                    statisticItem.param("obj_locate", 3);
                }
                TiebaStatic.log(statisticItem);
            }
            c.a.q0.n0.c findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view);
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
            d();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, view, motionEvent)) == null) {
            TiebaStatic.log(new StatisticItem("c13339").param("uid", this.p).param("post_id", this.f39485e.threadId));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void setExpandButtonListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.q = aVar;
        }
    }

    public void setOnDownloadImageListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.s = bVar;
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.f39489i.setOnClickListener(onClickListener);
        }
    }

    public void setOnShareImageListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.r = cVar;
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.p = str;
        }
    }

    public void setYoungterCoverSomeView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.u = false;
            this.f39489i.setVisibility(z ? 8 : 0);
            this.l.setVisibility(z ? 8 : 0);
            this.m.setVisibility(z ? 8 : 0);
            this.k.setVisibility(z ? 8 : 0);
            this.n.setVisibility(z ? 8 : 0);
        }
    }

    public void updateData(ImageUrlData imageUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, imageUrlData) == null) {
            this.f39485e = imageUrlData;
            if (imageUrlData != null && imageUrlData.agreeData != null) {
                setVisibility(0);
                String str = imageUrlData.commentNum;
                if (str != null) {
                    this.m.setText(str);
                }
                AgreeData agreeData = imageUrlData.agreeData;
                if (agreeData != null) {
                    this.k.setData(agreeData);
                }
                if (this.u) {
                    return;
                }
                this.f39488h.setVisibility(0);
                return;
            }
            setVisibility(8);
        }
    }

    public void updateUnfoldState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.f39486f.setText(getContext().getString(R.string.expand));
                WebPManager.setMaskDrawable(this.f39487g, R.drawable.icon_mask_fold30, null);
                this.f39490j.setVisibility(8);
                this.f39489i.setVisibility(8);
                return;
            }
            this.f39486f.setText(getContext().getString(R.string.fold));
            WebPManager.setMaskDrawable(this.f39487g, R.drawable.icon_mask_unfold30, null);
            this.f39490j.setVisibility(0);
            this.f39489i.setVisibility(0);
        }
    }
}
