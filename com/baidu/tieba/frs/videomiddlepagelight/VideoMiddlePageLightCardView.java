package com.baidu.tieba.frs.videomiddlepagelight;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AbstractData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.o0.r.q.b2;
import d.a.o0.r.q.x1;
import d.a.p0.h3.h0.p;
import d.a.p0.n2.c;
import d.a.p0.n2.o;
import d.a.p0.u0.h1.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Ø\u00012\u00020\u0001:\u0002Ø\u0001B\u001f\u0012\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001a\u0012\b\u0010Ò\u0001\u001a\u00030Ñ\u0001¢\u0006\u0006\bÖ\u0001\u0010×\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0013J\u001b\u0010\u001c\u001a\u00020\u00042\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u00042\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\rH\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010(\u001a\u00020'2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b*\u0010\u0006J\u001f\u0010*\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b*\u0010+J#\u0010-\u001a\u00020\u00042\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010,\u001a\u00020\rH\u0016¢\u0006\u0004\b-\u0010.J\u0019\u00101\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0004H\u0016¢\u0006\u0004\b3\u0010\u0013J\u0017\u00105\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u000204H\u0002¢\u0006\u0004\b5\u00106R\u0019\u00108\u001a\u0002078\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R$\u0010<\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010\u0006R\"\u0010A\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010#\"\u0004\bD\u0010\u0016R\"\u0010E\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010B\u001a\u0004\bF\u0010#\"\u0004\bG\u0010\u0016R\"\u0010H\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010B\u001a\u0004\bI\u0010#\"\u0004\bJ\u0010\u0016R\u0019\u0010L\u001a\u00020K8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0019\u0010Q\u001a\u00020P8\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u0019\u0010V\u001a\u00020U8\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u0019\u0010Z\u001a\u0002078\u0006@\u0006¢\u0006\f\n\u0004\bZ\u00109\u001a\u0004\b[\u0010;R\u0019\u0010]\u001a\u00020\\8\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0019\u0010b\u001a\u00020a8\u0006@\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u0019\u0010f\u001a\u00020P8\u0006@\u0006¢\u0006\f\n\u0004\bf\u0010R\u001a\u0004\bg\u0010TR\u0019\u0010i\u001a\u00020h8\u0006@\u0006¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR$\u0010m\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u0019\u0010s\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\bs\u0010B\u001a\u0004\bt\u0010#R\"\u0010u\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bu\u0010w\"\u0004\bx\u0010yR\u0019\u0010{\u001a\u00020z8\u0006@\u0006¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R'\u0010\u007f\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R(\u0010\u0085\u0001\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0085\u0001\u0010\u0080\u0001\u001a\u0005\b(\u0010\u0082\u0001\"\u0006\b\u0086\u0001\u0010\u0084\u0001R\u001c\u0010\u0087\u0001\u001a\u0002078\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0087\u0001\u00109\u001a\u0005\b\u0088\u0001\u0010;R\u001c\u0010\u0089\u0001\u001a\u00020P8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0089\u0001\u0010R\u001a\u0005\b\u008a\u0001\u0010TR\u001f\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R,\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001c\u0010\u0097\u0001\u001a\u0002078\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0097\u0001\u00109\u001a\u0005\b\u0098\u0001\u0010;R\u001f\u0010\u009a\u0001\u001a\u00030\u0099\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001c\u0010\u009e\u0001\u001a\u0002078\u0006@\u0006¢\u0006\u000e\n\u0005\b\u009e\u0001\u00109\u001a\u0005\b\u009f\u0001\u0010;R\u001c\u0010 \u0001\u001a\u00020a8\u0006@\u0006¢\u0006\u000e\n\u0005\b \u0001\u0010c\u001a\u0005\b¡\u0001\u0010eR\u001f\u0010£\u0001\u001a\u00030¢\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001R\u001c\u0010§\u0001\u001a\u00020P8\u0006@\u0006¢\u0006\u000e\n\u0005\b§\u0001\u0010R\u001a\u0005\b¨\u0001\u0010TR\u001c\u0010©\u0001\u001a\u00020\r8\u0006@\u0006¢\u0006\u000e\n\u0005\b©\u0001\u0010B\u001a\u0005\bª\u0001\u0010#R\u001f\u0010«\u0001\u001a\u00030\u008b\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b«\u0001\u0010\u008d\u0001\u001a\u0006\b¬\u0001\u0010\u008f\u0001R\u001f\u0010®\u0001\u001a\u00030\u00ad\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b®\u0001\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001R\u001f\u0010³\u0001\u001a\u00030²\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001R\u001c\u0010·\u0001\u001a\u00020a8\u0006@\u0006¢\u0006\u000e\n\u0005\b·\u0001\u0010c\u001a\u0005\b¸\u0001\u0010eR\u001c\u0010¹\u0001\u001a\u00020a8\u0006@\u0006¢\u0006\u000e\n\u0005\b¹\u0001\u0010c\u001a\u0005\bº\u0001\u0010eR\u001c\u0010»\u0001\u001a\u00020P8\u0006@\u0006¢\u0006\u000e\n\u0005\b»\u0001\u0010R\u001a\u0005\b¼\u0001\u0010TR\u001c\u0010½\u0001\u001a\u00020P8\u0006@\u0006¢\u0006\u000e\n\u0005\b½\u0001\u0010R\u001a\u0005\b¾\u0001\u0010TR\u001c\u0010¿\u0001\u001a\u00020\r8\u0006@\u0006¢\u0006\u000e\n\u0005\b¿\u0001\u0010B\u001a\u0005\bÀ\u0001\u0010#R\u001f\u0010Á\u0001\u001a\u00030\u008b\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÁ\u0001\u0010\u008d\u0001\u001a\u0006\bÂ\u0001\u0010\u008f\u0001R\u001f\u0010Ä\u0001\u001a\u00030Ã\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u001f\u0010É\u0001\u001a\u00030È\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001R\u001f\u0010Í\u0001\u001a\u00020\r8\u0006@\u0006X\u0086D¢\u0006\u000e\n\u0005\bÍ\u0001\u0010B\u001a\u0005\bÎ\u0001\u0010#R\u001f\u0010Ï\u0001\u001a\u00020\r8\u0006@\u0006X\u0086D¢\u0006\u000e\n\u0005\bÏ\u0001\u0010B\u001a\u0005\bÐ\u0001\u0010#R\u001f\u0010Ò\u0001\u001a\u00030Ñ\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001¨\u0006Ù\u0001"}, d2 = {"Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightCardView;", "Ld/a/p0/a0/b;", "Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;", "data", "", "bindHeadData", "(Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;)V", "Lcom/baidu/tbadk/core/data/ThreadData;", "threadData", "", "bindOpData", "(Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;Lcom/baidu/tbadk/core/data/ThreadData;)Z", "bindReplyData", "", "position", "bindVideoData", "(ILcom/baidu/tieba/frs/aggregation/VideoAggregationData;)V", "bindVideoInfoData", "changeReplyContentColor", "()V", "videoTitleStatus", "changeVideoTitleStatus", "(I)V", "changeVideoTitleStyleExpandBtnArrowDown", "changeVideoTitleStyleExpandBtnArrowUp", "changeVideoTitleStyleNoExpandBtn", "Lcom/baidu/tbadk/TbPageContext;", "pageContext", "enterFullScreen", "(Lcom/baidu/tbadk/TbPageContext;)V", "exitFullScreen", "Lcom/baidu/tieba/play/VideoStatsData;", "generateVideoStatsData", "(Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;)Lcom/baidu/tieba/play/VideoStatsData;", "getLayout", "()I", "", "Lcom/baidu/tbadk/core/data/AbstractData;", "abstractDataList", "", "getPostContent", "(Ljava/util/List;)Ljava/lang/String;", "onBindDataToView", "(Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;I)V", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(Lcom/baidu/tbadk/TbPageContext;I)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", MissionEvent.MESSAGE_DESTROY, "Lcom/baidu/tieba/frs/aggregation/VideoAggregationData$VideoAggregationAuthorData;", "setUserAvatar", "(Lcom/baidu/tieba/frs/aggregation/VideoAggregationData$VideoAggregationAuthorData;)V", "Landroid/view/View$OnClickListener;", "cardClickListener", "Landroid/view/View$OnClickListener;", "getCardClickListener", "()Landroid/view/View$OnClickListener;", "curData", "Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;", "getCurData", "()Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;", "setCurData", "curPos", "I", "getCurPos", "setCurPos", "curScreenOrientation", "getCurScreenOrientation", "setCurScreenOrientation", "curVideoTitleStatus", "getCurVideoTitleStatus", "setCurVideoTitleStatus", "Lcom/baidu/tieba/play/FloatVideoContainer;", "floatVideoContainer", "Lcom/baidu/tieba/play/FloatVideoContainer;", "getFloatVideoContainer", "()Lcom/baidu/tieba/play/FloatVideoContainer;", "Landroid/widget/TextView;", "forumInfoAuthor", "Landroid/widget/TextView;", "getForumInfoAuthor", "()Landroid/widget/TextView;", "Lcom/baidu/tbadk/core/view/SingleLineEllipsizeTextView;", "forumInfoBarname", "Lcom/baidu/tbadk/core/view/SingleLineEllipsizeTextView;", "getForumInfoBarname", "()Lcom/baidu/tbadk/core/view/SingleLineEllipsizeTextView;", "forumInfoClickListener", "getForumInfoClickListener", "Lcom/baidu/tbadk/core/view/BarImageView;", "forumInfoImage", "Lcom/baidu/tbadk/core/view/BarImageView;", "getForumInfoImage", "()Lcom/baidu/tbadk/core/view/BarImageView;", "Landroid/widget/RelativeLayout;", "forumInfoLayout", "Landroid/widget/RelativeLayout;", "getForumInfoLayout", "()Landroid/widget/RelativeLayout;", "forumInfoReplyTime", "getForumInfoReplyTime", "Lcom/baidu/tieba/play/FloatVideoContainer$OnFullScreenStateListener;", "fullScreenStateListener", "Lcom/baidu/tieba/play/FloatVideoContainer$OnFullScreenStateListener;", "getFullScreenStateListener", "()Lcom/baidu/tieba/play/FloatVideoContainer$OnFullScreenStateListener;", "generateThreadData", "Lcom/baidu/tbadk/core/data/ThreadData;", "getGenerateThreadData", "()Lcom/baidu/tbadk/core/data/ThreadData;", "setGenerateThreadData", "(Lcom/baidu/tbadk/core/data/ThreadData;)V", "horizontalVideoHeight", "getHorizontalVideoHeight", "isVerticalVideo", "Z", "()Z", "setVerticalVideo", "(Z)V", "Lcom/baidu/tbadk/core/view/ThreadCardBottomOpSegmentLayout;", "opLayout", "Lcom/baidu/tbadk/core/view/ThreadCardBottomOpSegmentLayout;", "getOpLayout", "()Lcom/baidu/tbadk/core/view/ThreadCardBottomOpSegmentLayout;", "postAuthorName", "Ljava/lang/String;", "getPostAuthorName", "()Ljava/lang/String;", "setPostAuthorName", "(Ljava/lang/String;)V", "postContent", "setPostContent", "replyAreaClickListener", "getReplyAreaClickListener", "replyContent", "getReplyContent", "Landroid/widget/FrameLayout;", "replyLayout", "Landroid/widget/FrameLayout;", "getReplyLayout", "()Landroid/widget/FrameLayout;", "Landroid/text/SpannableString;", "showContent", "Landroid/text/SpannableString;", "getShowContent", "()Landroid/text/SpannableString;", "setShowContent", "(Landroid/text/SpannableString;)V", "titleAreaExpandClickListener", "getTitleAreaExpandClickListener", "Lcom/baidu/tbadk/core/view/HeadImageView;", "userInfoAvatar", "Lcom/baidu/tbadk/core/view/HeadImageView;", "getUserInfoAvatar", "()Lcom/baidu/tbadk/core/view/HeadImageView;", "userInfoClickListener", "getUserInfoClickListener", "userInfoLayout", "getUserInfoLayout", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "userInfoName", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "getUserInfoName", "()Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "userInfoReplyTime", "getUserInfoReplyTime", "verticalVideoHeight", "getVerticalVideoHeight", "videoContainer", "getVideoContainer", "Lcom/baidu/tieba/play/FloatVideoContainer$VideoEvent;", "videoEventCallback", "Lcom/baidu/tieba/play/FloatVideoContainer$VideoEvent;", "getVideoEventCallback", "()Lcom/baidu/tieba/play/FloatVideoContainer$VideoEvent;", "Landroid/widget/ImageView;", "videoInfoExpandTitleBtn", "Landroid/widget/ImageView;", "getVideoInfoExpandTitleBtn", "()Landroid/widget/ImageView;", "videoInfoExpandTitleBtnWrapper", "getVideoInfoExpandTitleBtnWrapper", "videoInfoLayout", "getVideoInfoLayout", "videoInfoPlayCount", "getVideoInfoPlayCount", "videoInfoTitle", "getVideoInfoTitle", "videoInfoTitleMaxLength", "getVideoInfoTitleMaxLength", "videoLayout", "getVideoLayout", "Lcom/baidu/tieba/play/operableVideoView/OperableVideoNetworkStateTipView;", "videoNetworkStateTip", "Lcom/baidu/tieba/play/operableVideoView/OperableVideoNetworkStateTipView;", "getVideoNetworkStateTip", "()Lcom/baidu/tieba/play/operableVideoView/OperableVideoNetworkStateTipView;", "Lcom/baidu/tieba/play/FloatVideoContainer$VideoStatisticCallback;", "videoStatisticCallback", "Lcom/baidu/tieba/play/FloatVideoContainer$VideoStatisticCallback;", "getVideoStatisticCallback", "()Lcom/baidu/tieba/play/FloatVideoContainer$VideoStatisticCallback;", "videoTitleExpandMaxLines", "getVideoTitleExpandMaxLines", "videoTitleFoldMaxLines", "getVideoTitleFoldMaxLines", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "viewModel", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "getViewModel", "()Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "<init>", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;)V", "Companion", "frsExtra_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class VideoMiddlePageLightCardView extends d.a.p0.a0.b<d.a.p0.u0.h1.g> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RelativeLayout A;
    public final HeadImageView B;
    public final EMTextView C;
    public final TextView D;
    public final View.OnClickListener E;
    public final FrameLayout F;
    public final FrameLayout G;
    public final d.a.p0.n2.c H;
    public final OperableVideoNetworkStateTipView I;
    public final RelativeLayout J;
    public final TextView K;
    public int L;
    public final int M;
    public final int N;
    public final int O;
    public final ImageView P;
    public final RelativeLayout Q;
    public final TextView R;
    public final View.OnClickListener S;
    public final FrameLayout T;
    public final TextView U;
    public String V;
    public String W;
    public SpannableString X;
    public final View.OnClickListener Y;
    public final ThreadCardBottomOpSegmentLayout Z;
    public final c.k0 a0;
    public final c.x b0;
    public final c.j0 c0;
    public final VideoMiddlePageViewModel i0;
    public final int m;
    public final int n;
    public d.a.p0.u0.h1.g o;
    public b2 p;
    public int q;
    public int r;
    public boolean s;
    public final View.OnClickListener t;
    public final RelativeLayout u;
    public final BarImageView v;
    public final SingleLineEllipsizeTextView w;
    public final TextView x;
    public final TextView y;
    public final View.OnClickListener z;

    /* loaded from: classes4.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f16124e;

        public a(VideoMiddlePageLightCardView videoMiddlePageLightCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageLightCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16124e = videoMiddlePageLightCardView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g.c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16124e.R().setVisibility(8);
                this.f16124e.R().setHasAgreeToPlay(true);
                this.f16124e.O().k2();
                this.f16124e.O().n1(false);
                d.a.p0.u0.h1.g K = this.f16124e.K();
                if ((K != null ? K.z : null) != null) {
                    d.a.p0.n2.c O = this.f16124e.O();
                    d.a.p0.u0.h1.g K2 = this.f16124e.K();
                    String str = (K2 == null || (cVar = K2.z) == null) ? null : cVar.f62876d;
                    d.a.p0.u0.h1.g K3 = this.f16124e.K();
                    O.d2(str, K3 != null ? K3.f62849f : null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b<T> implements Observer<Configuration> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f16125e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16126f;

        public b(VideoMiddlePageLightCardView videoMiddlePageLightCardView, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageLightCardView, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16125e = videoMiddlePageLightCardView;
            this.f16126f = tbPageContext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(Configuration configuration) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, configuration) == null) {
                Integer value = this.f16125e.S().c().getValue();
                int L = this.f16125e.L();
                if (value != null && value.intValue() == L) {
                    int M = this.f16125e.M();
                    int i2 = configuration.orientation;
                    if (M != i2) {
                        if (i2 == 2) {
                            this.f16125e.H(this.f16126f);
                        } else {
                            this.f16125e.I(this.f16126f);
                        }
                        this.f16125e.O().V0(this.f16126f, configuration);
                        this.f16125e.X(configuration.orientation);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f16127e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16128f;

        public c(VideoMiddlePageLightCardView videoMiddlePageLightCardView, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageLightCardView, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16127e = videoMiddlePageLightCardView;
            this.f16128f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16127e.K() == null) {
                return;
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f16127e.f53778g);
            d.a.p0.u0.h1.g K = this.f16127e.K();
            pbActivityConfig.createNormalCfg(K != null ? K.f62849f : null, null, null);
            pbActivityConfig.setVideo_source("auto_midpage");
            d.a.p0.u0.h1.g K2 = this.f16127e.K();
            pbActivityConfig.setBjhData(K2 != null ? K2.A : null);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            b2 P = this.f16127e.P();
            d.a.p0.u0.h1.g K3 = this.f16127e.K();
            d.a.p0.g3.c.g().c(this.f16128f.getUniqueId(), d.a.p0.g3.a.d(P, "a023", "common_click", 1, K3 != null ? K3.I : 0, false, null, null));
        }
    }

    /* loaded from: classes4.dex */
    public static final class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f16129e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16130f;

        public d(VideoMiddlePageLightCardView videoMiddlePageLightCardView, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageLightCardView, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16129e = videoMiddlePageLightCardView;
            this.f16130f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d.a.p0.u0.h1.g K;
            x1 x1Var;
            String str;
            x1 x1Var2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (K = this.f16129e.K()) == null || (x1Var = K.B) == null || (str = x1Var.f52815b) == null) {
                return;
            }
            if (str.length() > 0) {
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.f16129e.b());
                d.a.p0.u0.h1.g K2 = this.f16129e.K();
                FrsActivityConfig createNormalCfg = frsActivityConfig.createNormalCfg((K2 == null || (x1Var2 = K2.B) == null) ? null : x1Var2.f52815b, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                b2 P = this.f16129e.P();
                d.a.p0.u0.h1.g K3 = this.f16129e.K();
                d.a.p0.g3.c.g().c(this.f16130f.getUniqueId(), d.a.p0.g3.a.d(P, "a023", "common_click", 9, K3 != null ? K3.I : 0, false, null, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class e implements c.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f16131a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16132b;

        public e(VideoMiddlePageLightCardView videoMiddlePageLightCardView, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageLightCardView, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16131a = videoMiddlePageLightCardView;
            this.f16132b = tbPageContext;
        }

        @Override // d.a.p0.n2.c.x
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f16131a.T()) {
                this.f16131a.H(this.f16132b);
            }
        }

        @Override // d.a.p0.n2.c.x
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f16131a.T()) {
                this.f16131a.I(this.f16132b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f16133e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16134f;

        public f(VideoMiddlePageLightCardView videoMiddlePageLightCardView, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageLightCardView, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16133e = videoMiddlePageLightCardView;
            this.f16134f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            List<p> list;
            p pVar;
            x1 x1Var;
            List<p> list2;
            p pVar2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16133e.K() == null) {
                return;
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f16133e.f53778g);
            d.a.p0.u0.h1.g K = this.f16133e.K();
            String str = null;
            String str2 = K != null ? K.f62849f : null;
            d.a.p0.u0.h1.g K2 = this.f16133e.K();
            PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(str2, (K2 == null || (list2 = K2.D) == null || (pVar2 = list2.get(0)) == null || (r2 = pVar2.f58008a) == null) ? "" : "", null);
            createNormalCfg.setStartFrom(24);
            d.a.p0.u0.h1.g K3 = this.f16133e.K();
            createNormalCfg.setForumId(K3 != null ? K3.f62848e : null);
            d.a.p0.u0.h1.g K4 = this.f16133e.K();
            createNormalCfg.setForumName((K4 == null || (x1Var = K4.B) == null) ? null : x1Var.f52815b);
            d.a.p0.u0.h1.g K5 = this.f16133e.K();
            if (K5 != null && (list = K5.D) != null && (pVar = list.get(0)) != null) {
                str = pVar.f58008a;
            }
            createNormalCfg.setHighLightPostId(str);
            createNormalCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            b2 P = this.f16133e.P();
            d.a.p0.u0.h1.g K6 = this.f16133e.K();
            d.a.p0.g3.c.g().c(this.f16134f.getUniqueId(), d.a.p0.g3.a.d(P, "a023", "common_click", 5, K6 != null ? K6.I : 0, false, null, null));
        }
    }

    /* loaded from: classes4.dex */
    public static final class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f16135e;

        public g(VideoMiddlePageLightCardView videoMiddlePageLightCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageLightCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16135e = videoMiddlePageLightCardView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f16135e.N() == 1) {
                    this.f16135e.A(2);
                } else if (this.f16135e.N() == 2) {
                    this.f16135e.A(1);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f16136e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16137f;

        public h(VideoMiddlePageLightCardView videoMiddlePageLightCardView, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageLightCardView, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16136e = videoMiddlePageLightCardView;
            this.f16137f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g.b bVar;
            g.b bVar2;
            g.b bVar3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.p0.u0.h1.g K = this.f16136e.K();
                String str = null;
                String str2 = (K == null || (bVar3 = K.y) == null) ? null : bVar3.f62859a;
                d.a.p0.u0.h1.g K2 = this.f16136e.K();
                String str3 = (K2 == null || (bVar2 = K2.y) == null) ? null : bVar2.f62861c;
                if (str3 == null || StringsKt__StringsJVMKt.isBlank(str3)) {
                    d.a.p0.u0.h1.g K3 = this.f16136e.K();
                    if (K3 != null && (bVar = K3.y) != null) {
                        str = bVar.f62860b;
                    }
                    str3 = str;
                }
                if (str2 != null && (!StringsKt__StringsJVMKt.isBlank(str2)) && str3 != null && (!StringsKt__StringsJVMKt.isBlank(str3))) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f16136e.b(), str2, str3)));
                }
                b2 P = this.f16136e.P();
                d.a.p0.u0.h1.g K4 = this.f16136e.K();
                d.a.p0.g3.c.g().c(this.f16137f.getUniqueId(), d.a.p0.g3.a.d(P, "a023", "common_click", 2, K4 != null ? K4.I : 0, false, null, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class i implements c.j0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f16138a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public i(VideoMiddlePageLightCardView videoMiddlePageLightCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageLightCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16138a = videoMiddlePageLightCardView;
        }

        @Override // d.a.p0.n2.c.j0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // d.a.p0.n2.c.j0
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // d.a.p0.n2.c.j0
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // d.a.p0.n2.c.j0
        public void onPaused() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // d.a.p0.n2.c.j0
        public void onPlayEnd() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f16138a.M() == 1 && !this.f16138a.O().R0()) {
                this.f16138a.S().n();
            }
        }

        @Override // d.a.p0.n2.c.j0
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // d.a.p0.n2.c.j0
        public void onStarted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class j implements c.k0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f16139a;

        public j(VideoMiddlePageLightCardView videoMiddlePageLightCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageLightCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16139a = videoMiddlePageLightCardView;
        }

        @Override // d.a.p0.n2.c.k0
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int L = this.f16139a.L();
                Integer value = this.f16139a.S().c().getValue();
                if (value != null && L == value.intValue()) {
                    return;
                }
                this.f16139a.S().o(this.f16139a.L());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2023905325, "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightCardView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2023905325, "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightCardView;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMiddlePageLightCardView(TbPageContext<?> tbPageContext, VideoMiddlePageViewModel videoMiddlePageViewModel) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, videoMiddlePageViewModel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i0 = videoMiddlePageViewModel;
        this.m = (int) (l.k(tbPageContext.getPageActivity()) * 0.5625d);
        this.n = (int) (l.k(tbPageContext.getPageActivity()) * 1.0d);
        this.r = 1;
        this.t = new c(this, tbPageContext);
        View findViewById = k().findViewById(R.id.forum_info_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.forum_info_layout)");
        this.u = (RelativeLayout) findViewById;
        View findViewById2 = k().findViewById(R.id.forum_info_image);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.forum_info_image)");
        this.v = (BarImageView) findViewById2;
        View findViewById3 = k().findViewById(R.id.forum_info_barname);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "view.findViewById(R.id.forum_info_barname)");
        this.w = (SingleLineEllipsizeTextView) findViewById3;
        View findViewById4 = k().findViewById(R.id.forum_info_author);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "view.findViewById(R.id.forum_info_author)");
        this.x = (TextView) findViewById4;
        View findViewById5 = k().findViewById(R.id.forum_info_reply_time);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "view.findViewById(R.id.forum_info_reply_time)");
        this.y = (TextView) findViewById5;
        this.z = new d(this, tbPageContext);
        View findViewById6 = k().findViewById(R.id.user_info_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "view.findViewById(R.id.user_info_layout)");
        this.A = (RelativeLayout) findViewById6;
        View findViewById7 = k().findViewById(R.id.user_info_avatar);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, "view.findViewById(R.id.user_info_avatar)");
        this.B = (HeadImageView) findViewById7;
        View findViewById8 = k().findViewById(R.id.user_info_name);
        Intrinsics.checkExpressionValueIsNotNull(findViewById8, "view.findViewById(R.id.user_info_name)");
        this.C = (EMTextView) findViewById8;
        View findViewById9 = k().findViewById(R.id.user_info_reply_time);
        Intrinsics.checkExpressionValueIsNotNull(findViewById9, "view.findViewById(R.id.user_info_reply_time)");
        this.D = (TextView) findViewById9;
        this.E = new h(this, tbPageContext);
        View findViewById10 = k().findViewById(R.id.video_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById10, "view.findViewById(R.id.video_layout)");
        this.F = (FrameLayout) findViewById10;
        View findViewById11 = k().findViewById(R.id.video_container);
        Intrinsics.checkExpressionValueIsNotNull(findViewById11, "view.findViewById(R.id.video_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById11;
        this.G = frameLayout;
        this.H = new d.a.p0.n2.c(tbPageContext, frameLayout, false);
        View findViewById12 = k().findViewById(R.id.video_network_state_tip);
        Intrinsics.checkExpressionValueIsNotNull(findViewById12, "view.findViewById(R.id.video_network_state_tip)");
        this.I = (OperableVideoNetworkStateTipView) findViewById12;
        View findViewById13 = k().findViewById(R.id.video_info_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById13, "view.findViewById(R.id.video_info_layout)");
        this.J = (RelativeLayout) findViewById13;
        View findViewById14 = k().findViewById(R.id.video_info_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById14, "view.findViewById(R.id.video_info_title)");
        this.K = (TextView) findViewById14;
        this.M = 1;
        this.N = 3;
        this.O = (l.k(TbadkCoreApplication.getInst()) - this.J.getPaddingLeft()) - this.J.getPaddingRight();
        View findViewById15 = k().findViewById(R.id.video_info_expand_title_btn);
        Intrinsics.checkExpressionValueIsNotNull(findViewById15, "view.findViewById(R.id.v…eo_info_expand_title_btn)");
        this.P = (ImageView) findViewById15;
        View findViewById16 = k().findViewById(R.id.video_info_expand_title_btn_wrapper);
        Intrinsics.checkExpressionValueIsNotNull(findViewById16, "view.findViewById(R.id.v…expand_title_btn_wrapper)");
        this.Q = (RelativeLayout) findViewById16;
        View findViewById17 = k().findViewById(R.id.video_info_play_count);
        Intrinsics.checkExpressionValueIsNotNull(findViewById17, "view.findViewById(R.id.video_info_play_count)");
        this.R = (TextView) findViewById17;
        this.S = new g(this);
        View findViewById18 = k().findViewById(R.id.reply_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById18, "view.findViewById(R.id.reply_layout)");
        this.T = (FrameLayout) findViewById18;
        View findViewById19 = k().findViewById(R.id.reply_content);
        Intrinsics.checkExpressionValueIsNotNull(findViewById19, "view.findViewById(R.id.reply_content)");
        this.U = (TextView) findViewById19;
        this.V = "";
        this.W = "";
        this.Y = new f(this, tbPageContext);
        View findViewById20 = k().findViewById(R.id.op_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById20, "view.findViewById(R.id.op_layout)");
        this.Z = (ThreadCardBottomOpSegmentLayout) findViewById20;
        this.a0 = new j(this);
        this.b0 = new e(this, tbPageContext);
        this.c0 = new i(this);
        this.u.setOnClickListener(this.z);
        this.v.setShowOval(true);
        this.v.setAutoChangeStyle(true);
        this.v.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.v.setStrokeColorResId(R.color.CAM_X0401);
        this.v.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.v.setPlaceHolder(1);
        this.v.setOnClickListener(this.z);
        SingleLineEllipsizeTextView singleLineEllipsizeTextView = this.w;
        View view = k();
        Intrinsics.checkExpressionValueIsNotNull(view, "view");
        singleLineEllipsizeTextView.setEllipsisSuffix(view.getResources().getString(R.string.ellipsis_suffix_bar));
        this.w.setOnClickListener(this.z);
        this.w.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - UtilHelper.getDimenPixelSize(R.dimen.M_H_X005), 0, 0);
        this.A.setOnClickListener(this.E);
        this.B.setIsRound(true);
        this.B.setPlaceHolder(1);
        this.B.setOnClickListener(this.E);
        this.C.setOnClickListener(this.E);
        this.H.O1("2005");
        this.H.q1(true);
        this.H.r1(true);
        this.H.s1(true);
        this.H.v1(true);
        this.H.t1(true);
        this.H.r1(true);
        this.H.M1(false, false);
        this.H.o1(false);
        this.H.y1(this.b0);
        this.H.U1(this.a0);
        this.H.l1(this.c0);
        this.I.setPlayViewOnClickListener(new a(this));
        MutableLiveData<Configuration> b2 = this.i0.b();
        Activity pageActivity = tbPageContext.getPageActivity();
        if (pageActivity != null) {
            b2.observe((LifecycleOwner) pageActivity, new b(this, tbPageContext));
            this.J.setOnClickListener(this.t);
            this.Q.setOnClickListener(this.S);
            this.T.setOnClickListener(this.Y);
            this.Z.setReplyTimeVisible(false);
            this.Z.setShowPraiseNum(true);
            this.Z.setNeedAddPraiseIcon(true);
            this.Z.setNeedAddReplyIcon(true);
            this.Z.setShareVisible(true);
            this.Z.hideDisagree();
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkCoreApplication.getInst()");
            m(tbPageContext, inst.getSkinType());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    public final void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.L = i2;
            if (i2 == 0) {
                G();
            } else if (i2 == 1) {
                B();
            } else if (i2 != 2) {
            } else {
                F();
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.Q.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.P, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            this.K.setEllipsize(TextUtils.TruncateAt.END);
            this.K.setMaxLines(this.M);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.Q.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.P, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null);
            this.K.setEllipsize(null);
            this.K.setMaxLines(this.N);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.Q.setVisibility(8);
            this.K.setEllipsize(null);
            this.K.setMaxLines(this.M);
        }
    }

    public final void H(TbPageContext<?> tbPageContext) {
        Window window;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (pageActivity != null) {
                ((BaseFragmentActivity) pageActivity).setSwipeBackEnabled(false);
                Activity pageActivity2 = tbPageContext.getPageActivity();
                View decorView = (pageActivity2 == null || (window = pageActivity2.getWindow()) == null) ? null : window.getDecorView();
                if (decorView != null) {
                    FrameLayout frameLayout = (FrameLayout) decorView;
                    if (this.G.getParent() != null) {
                        if (this.G.getParent() == frameLayout) {
                            frameLayout.removeView(this.G);
                        } else {
                            ViewParent parent = this.G.getParent();
                            FrameLayout frameLayout2 = this.F;
                            if (parent == frameLayout2) {
                                frameLayout2.removeView(this.G);
                            }
                        }
                    }
                    if (this.G.getParent() != null) {
                        return;
                    }
                    frameLayout.addView(this.G);
                    ViewGroup.LayoutParams layoutParams = this.G.getLayoutParams();
                    if (layoutParams != null) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                        layoutParams2.height = -1;
                        this.G.setLayoutParams(layoutParams2);
                        this.H.q0();
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            throw new TypeCastException("null cannot be cast to non-null type com.baidu.tbadk.core.BaseFragmentActivity");
        }
    }

    public final void I(TbPageContext<?> tbPageContext) {
        Window window;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            Activity pageActivity = tbPageContext.getPageActivity();
            if (pageActivity != null) {
                ((BaseFragmentActivity) pageActivity).setSwipeBackEnabled(true);
                Activity pageActivity2 = tbPageContext.getPageActivity();
                View decorView = (pageActivity2 == null || (window = pageActivity2.getWindow()) == null) ? null : window.getDecorView();
                if (decorView != null) {
                    FrameLayout frameLayout = (FrameLayout) decorView;
                    if (this.G.getParent() != null) {
                        if (this.G.getParent() == frameLayout) {
                            frameLayout.removeView(this.G);
                        } else {
                            ViewParent parent = this.G.getParent();
                            FrameLayout frameLayout2 = this.F;
                            if (parent == frameLayout2) {
                                frameLayout2.removeView(this.G);
                            }
                        }
                    }
                    if (this.G.getParent() != null) {
                        return;
                    }
                    this.F.addView(this.G, 0);
                    ViewGroup.LayoutParams layoutParams = this.G.getLayoutParams();
                    if (layoutParams != null) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                        layoutParams2.height = this.s ? this.n : this.m;
                        this.G.setLayoutParams(layoutParams2);
                        this.H.q0();
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
            }
            throw new TypeCastException("null cannot be cast to non-null type com.baidu.tbadk.core.BaseFragmentActivity");
        }
    }

    public final o J(d.a.p0.u0.h1.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gVar)) == null) {
            o oVar = new o();
            oVar.f60811c = gVar.f62849f;
            oVar.t = gVar.f62850g;
            oVar.f60812d = gVar.f62848e;
            oVar.f60813e = TbadkCoreApplication.getCurrentAccount();
            oVar.f60809a = "13";
            oVar.f60814f = gVar.q;
            oVar.f60815g = gVar.r;
            oVar.f60817i = this.i0.d();
            oVar.l = gVar.t;
            oVar.k = this.i0.e();
            oVar.o = gVar.s;
            oVar.p = this.s ? "1" : "0";
            oVar.j = gVar.h();
            return oVar;
        }
        return (o) invokeL.objValue;
    }

    public final d.a.p0.u0.h1.g K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.o : (d.a.p0.u0.h1.g) invokeV.objValue;
    }

    public final int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.q : invokeV.intValue;
    }

    public final int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.r : invokeV.intValue;
    }

    public final int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.L : invokeV.intValue;
    }

    public final d.a.p0.n2.c O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.H : (d.a.p0.n2.c) invokeV.objValue;
    }

    public final b2 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.p : (b2) invokeV.objValue;
    }

    public final String Q(List<? extends AbstractData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, list)) == null) {
            if (list == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            VideoMiddlePageLightCardView$getPostContent$1 videoMiddlePageLightCardView$getPostContent$1 = VideoMiddlePageLightCardView$getPostContent$1.INSTANCE;
            for (AbstractData abstractData : list) {
                sb.append(VideoMiddlePageLightCardView$getPostContent$1.INSTANCE.invoke(abstractData));
            }
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "postContent.toString()");
            return sb2;
        }
        return (String) invokeL.objValue;
    }

    public final OperableVideoNetworkStateTipView R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.I : (OperableVideoNetworkStateTipView) invokeV.objValue;
    }

    public final VideoMiddlePageViewModel S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.i0 : (VideoMiddlePageViewModel) invokeV.objValue;
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.s : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.a0.b
    /* renamed from: U */
    public void l(d.a.p0.u0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, gVar) == null) {
        }
    }

    public final void W(d.a.p0.u0.h1.g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048594, this, gVar, i2) == null) || gVar == null) {
            return;
        }
        this.o = gVar;
        this.p = d.a.p0.u0.h1.g.c(gVar);
        this.q = i2;
        this.s = gVar.j();
        u(gVar);
        x(i2, gVar);
        y(gVar);
        w(gVar);
        v(gVar, this.p);
    }

    public final void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.r = i2;
        }
    }

    public final void Y(g.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) || bVar == null) {
            return;
        }
        g.b.a aVar = bVar.f62866h;
        if (aVar != null && !TextUtils.isEmpty(aVar.f62868b)) {
            this.B.M(bVar.f62866h.f62868b, 12, false);
        } else {
            if (!StringUtils.isNull(bVar.f62862d)) {
                String str = bVar.f62862d;
                Intrinsics.checkExpressionValueIsNotNull(str, "data.portrait");
                if (StringsKt__StringsJVMKt.startsWith$default(str, "http", false, 2, null)) {
                    this.B.M(bVar.f62862d, 10, false);
                }
            }
            this.B.M(bVar.f62862d, 12, false);
        }
        g.b.a aVar2 = bVar.f62866h;
        if (aVar2 != null && Intrinsics.compare(aVar2.f62871e.intValue(), 0) > 0) {
            Integer num = bVar.f62866h.f62871e;
            Intrinsics.checkExpressionValueIsNotNull(num, "data.baijiahaoData.auth_id");
            this.B.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(num.intValue(), 1));
            this.B.setShowV(true);
            this.B.setGodIconWidth(R.dimen.tbds31);
            return;
        }
        this.B.setBjhAuthIconRes(0);
        boolean z = bVar.f62865g;
        if (z) {
            this.B.setShowV(z);
            this.B.setIsBigV(bVar.f62865g);
        } else {
            boolean z2 = bVar.f62864f;
            if (z2) {
                this.B.setShowV(z2);
                this.B.setIsBigV(bVar.f62864f);
            } else {
                this.B.setShowV(z2);
                this.B.setIsBigV(bVar.f62864f);
            }
        }
        this.B.setGodIconWidth(R.dimen.tbds31);
    }

    @Override // d.a.p0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? R.layout.card_video_middle_page_light_layout : invokeV.intValue;
    }

    @Override // d.a.p0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(k(), R.color.CAM_X0201);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba16, SkinManager.getColor(R.color.CAM_X0105), null);
            int g2 = l.g(b(), R.dimen.tbds42);
            pureDrawable.setBounds(0, 0, g2, g2);
            this.w.setCompoundDrawables(null, null, pureDrawable, null);
            this.w.setCompoundDrawablePadding(l.g(b(), R.dimen.M_W_X002));
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.x, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.y, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.D, R.color.CAM_X0109);
            this.K.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            A(this.L);
            this.R.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(this.T);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            z();
            this.Z.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, view) == null) {
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.H.v0();
        }
    }

    public final void u(d.a.p0.u0.h1.g gVar) {
        x1 x1Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, gVar) == null) {
            String str2 = null;
            if (gVar.h() == 1 && (x1Var = gVar.B) != null && (str = x1Var.f52815b) != null && (!StringsKt__StringsJVMKt.isBlank(str))) {
                this.u.setVisibility(0);
                this.A.setVisibility(8);
                BarImageView barImageView = this.v;
                x1 x1Var2 = gVar.B;
                barImageView.M(x1Var2 != null ? x1Var2.f52816c : null, 10, false);
                SingleLineEllipsizeTextView singleLineEllipsizeTextView = this.w;
                String string = b().getString(R.string.chosen_pb_original_bar);
                Object[] objArr = new Object[1];
                x1 x1Var3 = gVar.B;
                objArr[0] = x1Var3 != null ? x1Var3.f52815b : null;
                singleLineEllipsizeTextView.setText(String.format(string, objArr));
                TextView textView = this.x;
                StringBuilder sb = new StringBuilder();
                g.b bVar = gVar.y;
                if (TextUtils.isEmpty(bVar != null ? bVar.f62861c : null)) {
                    g.b bVar2 = gVar.y;
                    if (bVar2 != null) {
                        str2 = bVar2.f62860b;
                    }
                } else {
                    g.b bVar3 = gVar.y;
                    if (bVar3 != null) {
                        str2 = bVar3.f62861c;
                    }
                }
                sb.append(str2);
                sb.append(TbadkCoreApplication.getInst().getString(R.string.home_publish));
                textView.setText(sb.toString());
                if (gVar.C > 0) {
                    this.y.setVisibility(0);
                    TextView textView2 = this.y;
                    textView2.setText(TbadkCoreApplication.getInst().getString(R.string.repley_when) + StringHelper.getFormatTimeForHomeC(gVar.C * 1000));
                    return;
                }
                this.y.setVisibility(8);
                return;
            }
            this.A.setVisibility(0);
            this.u.setVisibility(8);
            g.b bVar4 = gVar.y;
            Intrinsics.checkExpressionValueIsNotNull(bVar4, "data.author");
            Y(bVar4);
            EMTextView eMTextView = this.C;
            g.b bVar5 = gVar.y;
            if (TextUtils.isEmpty(bVar5 != null ? bVar5.f62861c : null)) {
                g.b bVar6 = gVar.y;
                if (bVar6 != null) {
                    str2 = bVar6.f62860b;
                }
            } else {
                g.b bVar7 = gVar.y;
                if (bVar7 != null) {
                    str2 = bVar7.f62861c;
                }
            }
            eMTextView.setText(str2);
            if (gVar.C > 0) {
                this.D.setVisibility(0);
                TextView textView3 = this.D;
                textView3.setText(TbadkCoreApplication.getInst().getString(R.string.repley_when) + StringHelper.getFormatTimeForHomeC(gVar.C * 1000));
                return;
            }
            this.D.setVisibility(8);
        }
    }

    public final boolean v(d.a.p0.u0.h1.g gVar, b2 b2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, gVar, b2Var)) == null) ? this.Z.setData(b2Var) : invokeLL.booleanValue;
    }

    public final void w(d.a.p0.u0.h1.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, gVar) == null) {
            List<p> list = gVar.D;
            if (list != null && !list.isEmpty()) {
                this.T.setVisibility(0);
                p pVar = gVar.D.get(0);
                MetaData metaData = pVar.f58009b;
                if (metaData == null || (string = metaData.getName_show()) == null) {
                    string = TbadkCoreApplication.getInst().getString(R.string.user_name_default_txt);
                    Intrinsics.checkExpressionValueIsNotNull(string, "TbadkCoreApplication.get…ng.user_name_default_txt)");
                }
                this.V = string;
                this.W = (char) 65306 + Q(pVar.f58010c);
                this.X = new SpannableString(this.V + this.W);
                z();
                return;
            }
            this.T.setVisibility(8);
        }
    }

    public final void x(int i2, d.a.p0.u0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048605, this, i2, gVar) == null) || gVar.z == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
        if (layoutParams != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.height = this.s ? this.n : this.m;
            this.F.setLayoutParams(layoutParams2);
            this.H.L1(i2);
            this.H.S1(gVar.z.j);
            this.H.W1(3);
            this.H.T1(gVar.z.f62877e);
            this.H.Y1(gVar.z.f62876d, gVar.f62849f);
            this.H.m1(gVar.f62848e);
            this.H.I0().setVideoStatData(J(gVar));
            this.H.a1();
            this.H.a2();
            this.I.setVideoLength(gVar.z.f62880h);
            this.I.setVideoDuration(gVar.z.f62877e);
            this.I.setTid(gVar.f62849f);
            if (gVar.F) {
                this.H.c2(false);
                if (this.I.d()) {
                    this.I.a(this.s, this.H.R0());
                    this.I.setVisibility(0);
                    this.H.n1(true);
                    return;
                }
                this.I.setVisibility(8);
                this.H.n1(false);
                this.H.d2(gVar.z.f62876d, gVar.f62849f);
                return;
            }
            this.I.setVisibility(8);
            this.H.k2();
            this.H.c2(true);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    public final void y(d.a.p0.u0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, gVar) == null) {
            String str = gVar.x;
            if (str == null) {
                str = TbadkCoreApplication.getInst().getString(R.string.video_title_str);
            }
            int i2 = 0;
            float measureText = this.K.getPaint().measureText(str, 0, str.length());
            float textSize = this.K.getTextSize();
            int i3 = this.M;
            if (measureText + (textSize * i3) > this.O * i3) {
                int i4 = this.L;
                i2 = (i4 == 1 || i4 == 2) ? this.L : 1;
            }
            A(i2);
            this.K.setText(str);
            TextView textView = this.R;
            textView.setText(StringHelper.numberUniformFormatExtra(gVar.j) + TbadkCoreApplication.getInst().getString(R.string.play));
        }
    }

    public final void z() {
        SpannableString spannableString;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (!StringsKt__StringsJVMKt.isBlank(this.V))) {
            if (!(this.W.length() > 0) || (spannableString = this.X) == null) {
                return;
            }
            if (spannableString.length() > 0) {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0108));
                ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0106));
                SpannableString spannableString2 = this.X;
                if (spannableString2 != null) {
                    spannableString2.setSpan(foregroundColorSpan, 0, this.V.length(), 33);
                }
                SpannableString spannableString3 = this.X;
                if (spannableString3 != null) {
                    spannableString3.setSpan(foregroundColorSpan2, this.V.length(), this.V.length() + this.W.length(), 33);
                }
                this.U.setText(this.X);
            }
        }
    }
}
