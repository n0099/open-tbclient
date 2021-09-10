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
import c.a.e.e.p.l;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.z1;
import c.a.r0.j3.i0.q;
import c.a.r0.p2.c;
import c.a.r0.p2.o;
import c.a.r0.w0.h1.g;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Ø\u00012\u00020\u0001:\u0002Ø\u0001B\u001f\u0012\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001a\u0012\b\u0010Ò\u0001\u001a\u00030Ñ\u0001¢\u0006\u0006\bÖ\u0001\u0010×\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0013J\u001b\u0010\u001c\u001a\u00020\u00042\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u00042\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\rH\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010(\u001a\u00020'2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b*\u0010\u0006J\u001f\u0010*\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b*\u0010+J#\u0010-\u001a\u00020\u00042\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010,\u001a\u00020\rH\u0016¢\u0006\u0004\b-\u0010.J\u0019\u00101\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0004H\u0016¢\u0006\u0004\b3\u0010\u0013J\u0017\u00105\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u000204H\u0002¢\u0006\u0004\b5\u00106R\u0019\u00108\u001a\u0002078\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R$\u0010<\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010\u0006R\"\u0010A\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010#\"\u0004\bD\u0010\u0016R\"\u0010E\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010B\u001a\u0004\bF\u0010#\"\u0004\bG\u0010\u0016R\"\u0010H\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010B\u001a\u0004\bI\u0010#\"\u0004\bJ\u0010\u0016R\u0019\u0010L\u001a\u00020K8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0019\u0010Q\u001a\u00020P8\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u0019\u0010V\u001a\u00020U8\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u0019\u0010Z\u001a\u0002078\u0006@\u0006¢\u0006\f\n\u0004\bZ\u00109\u001a\u0004\b[\u0010;R\u0019\u0010]\u001a\u00020\\8\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0019\u0010b\u001a\u00020a8\u0006@\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u0019\u0010f\u001a\u00020P8\u0006@\u0006¢\u0006\f\n\u0004\bf\u0010R\u001a\u0004\bg\u0010TR\u0019\u0010i\u001a\u00020h8\u0006@\u0006¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR$\u0010m\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u0019\u0010s\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\bs\u0010B\u001a\u0004\bt\u0010#R\"\u0010u\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bu\u0010w\"\u0004\bx\u0010yR\u0019\u0010{\u001a\u00020z8\u0006@\u0006¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R'\u0010\u007f\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R(\u0010\u0085\u0001\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0085\u0001\u0010\u0080\u0001\u001a\u0005\b(\u0010\u0082\u0001\"\u0006\b\u0086\u0001\u0010\u0084\u0001R\u001c\u0010\u0087\u0001\u001a\u0002078\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0087\u0001\u00109\u001a\u0005\b\u0088\u0001\u0010;R\u001c\u0010\u0089\u0001\u001a\u00020P8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0089\u0001\u0010R\u001a\u0005\b\u008a\u0001\u0010TR\u001f\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R,\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001c\u0010\u0097\u0001\u001a\u0002078\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0097\u0001\u00109\u001a\u0005\b\u0098\u0001\u0010;R\u001f\u0010\u009a\u0001\u001a\u00030\u0099\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001c\u0010\u009e\u0001\u001a\u0002078\u0006@\u0006¢\u0006\u000e\n\u0005\b\u009e\u0001\u00109\u001a\u0005\b\u009f\u0001\u0010;R\u001c\u0010 \u0001\u001a\u00020a8\u0006@\u0006¢\u0006\u000e\n\u0005\b \u0001\u0010c\u001a\u0005\b¡\u0001\u0010eR\u001f\u0010£\u0001\u001a\u00030¢\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001R\u001c\u0010§\u0001\u001a\u00020P8\u0006@\u0006¢\u0006\u000e\n\u0005\b§\u0001\u0010R\u001a\u0005\b¨\u0001\u0010TR\u001c\u0010©\u0001\u001a\u00020\r8\u0006@\u0006¢\u0006\u000e\n\u0005\b©\u0001\u0010B\u001a\u0005\bª\u0001\u0010#R\u001f\u0010«\u0001\u001a\u00030\u008b\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b«\u0001\u0010\u008d\u0001\u001a\u0006\b¬\u0001\u0010\u008f\u0001R\u001f\u0010®\u0001\u001a\u00030\u00ad\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b®\u0001\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001R\u001f\u0010³\u0001\u001a\u00030²\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001R\u001c\u0010·\u0001\u001a\u00020a8\u0006@\u0006¢\u0006\u000e\n\u0005\b·\u0001\u0010c\u001a\u0005\b¸\u0001\u0010eR\u001c\u0010¹\u0001\u001a\u00020a8\u0006@\u0006¢\u0006\u000e\n\u0005\b¹\u0001\u0010c\u001a\u0005\bº\u0001\u0010eR\u001c\u0010»\u0001\u001a\u00020P8\u0006@\u0006¢\u0006\u000e\n\u0005\b»\u0001\u0010R\u001a\u0005\b¼\u0001\u0010TR\u001c\u0010½\u0001\u001a\u00020P8\u0006@\u0006¢\u0006\u000e\n\u0005\b½\u0001\u0010R\u001a\u0005\b¾\u0001\u0010TR\u001c\u0010¿\u0001\u001a\u00020\r8\u0006@\u0006¢\u0006\u000e\n\u0005\b¿\u0001\u0010B\u001a\u0005\bÀ\u0001\u0010#R\u001f\u0010Á\u0001\u001a\u00030\u008b\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÁ\u0001\u0010\u008d\u0001\u001a\u0006\bÂ\u0001\u0010\u008f\u0001R\u001f\u0010Ä\u0001\u001a\u00030Ã\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u001f\u0010É\u0001\u001a\u00030È\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001R\u001f\u0010Í\u0001\u001a\u00020\r8\u0006@\u0006X\u0086D¢\u0006\u000e\n\u0005\bÍ\u0001\u0010B\u001a\u0005\bÎ\u0001\u0010#R\u001f\u0010Ï\u0001\u001a\u00020\r8\u0006@\u0006X\u0086D¢\u0006\u000e\n\u0005\bÏ\u0001\u0010B\u001a\u0005\bÐ\u0001\u0010#R\u001f\u0010Ò\u0001\u001a\u00030Ñ\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001¨\u0006Ù\u0001"}, d2 = {"Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightCardView;", "Lc/a/r0/a0/b;", "Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;", "data", "", "bindHeadData", "(Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;)V", "Lcom/baidu/tbadk/core/data/ThreadData;", "threadData", "", "bindOpData", "(Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;Lcom/baidu/tbadk/core/data/ThreadData;)Z", "bindReplyData", "", "position", "bindVideoData", "(ILcom/baidu/tieba/frs/aggregation/VideoAggregationData;)V", "bindVideoInfoData", "changeReplyContentColor", "()V", "videoTitleStatus", "changeVideoTitleStatus", "(I)V", "changeVideoTitleStyleExpandBtnArrowDown", "changeVideoTitleStyleExpandBtnArrowUp", "changeVideoTitleStyleNoExpandBtn", "Lcom/baidu/tbadk/TbPageContext;", "pageContext", "enterFullScreen", "(Lcom/baidu/tbadk/TbPageContext;)V", "exitFullScreen", "Lcom/baidu/tieba/play/VideoStatsData;", "generateVideoStatsData", "(Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;)Lcom/baidu/tieba/play/VideoStatsData;", "getLayout", "()I", "", "Lcom/baidu/tbadk/core/data/AbstractData;", "abstractDataList", "", "getPostContent", "(Ljava/util/List;)Ljava/lang/String;", "onBindDataToView", "(Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;I)V", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(Lcom/baidu/tbadk/TbPageContext;I)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", MissionEvent.MESSAGE_DESTROY, "Lcom/baidu/tieba/frs/aggregation/VideoAggregationData$VideoAggregationAuthorData;", "setUserAvatar", "(Lcom/baidu/tieba/frs/aggregation/VideoAggregationData$VideoAggregationAuthorData;)V", "Landroid/view/View$OnClickListener;", "cardClickListener", "Landroid/view/View$OnClickListener;", "getCardClickListener", "()Landroid/view/View$OnClickListener;", "curData", "Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;", "getCurData", "()Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;", "setCurData", "curPos", "I", "getCurPos", "setCurPos", "curScreenOrientation", "getCurScreenOrientation", "setCurScreenOrientation", "curVideoTitleStatus", "getCurVideoTitleStatus", "setCurVideoTitleStatus", "Lcom/baidu/tieba/play/FloatVideoContainer;", "floatVideoContainer", "Lcom/baidu/tieba/play/FloatVideoContainer;", "getFloatVideoContainer", "()Lcom/baidu/tieba/play/FloatVideoContainer;", "Landroid/widget/TextView;", "forumInfoAuthor", "Landroid/widget/TextView;", "getForumInfoAuthor", "()Landroid/widget/TextView;", "Lcom/baidu/tbadk/core/view/SingleLineEllipsizeTextView;", "forumInfoBarname", "Lcom/baidu/tbadk/core/view/SingleLineEllipsizeTextView;", "getForumInfoBarname", "()Lcom/baidu/tbadk/core/view/SingleLineEllipsizeTextView;", "forumInfoClickListener", "getForumInfoClickListener", "Lcom/baidu/tbadk/core/view/BarImageView;", "forumInfoImage", "Lcom/baidu/tbadk/core/view/BarImageView;", "getForumInfoImage", "()Lcom/baidu/tbadk/core/view/BarImageView;", "Landroid/widget/RelativeLayout;", "forumInfoLayout", "Landroid/widget/RelativeLayout;", "getForumInfoLayout", "()Landroid/widget/RelativeLayout;", "forumInfoReplyTime", "getForumInfoReplyTime", "Lcom/baidu/tieba/play/FloatVideoContainer$OnFullScreenStateListener;", "fullScreenStateListener", "Lcom/baidu/tieba/play/FloatVideoContainer$OnFullScreenStateListener;", "getFullScreenStateListener", "()Lcom/baidu/tieba/play/FloatVideoContainer$OnFullScreenStateListener;", "generateThreadData", "Lcom/baidu/tbadk/core/data/ThreadData;", "getGenerateThreadData", "()Lcom/baidu/tbadk/core/data/ThreadData;", "setGenerateThreadData", "(Lcom/baidu/tbadk/core/data/ThreadData;)V", "horizontalVideoHeight", "getHorizontalVideoHeight", "isVerticalVideo", "Z", "()Z", "setVerticalVideo", "(Z)V", "Lcom/baidu/tbadk/core/view/ThreadCardBottomOpSegmentLayout;", "opLayout", "Lcom/baidu/tbadk/core/view/ThreadCardBottomOpSegmentLayout;", "getOpLayout", "()Lcom/baidu/tbadk/core/view/ThreadCardBottomOpSegmentLayout;", "postAuthorName", "Ljava/lang/String;", "getPostAuthorName", "()Ljava/lang/String;", "setPostAuthorName", "(Ljava/lang/String;)V", "postContent", "setPostContent", "replyAreaClickListener", "getReplyAreaClickListener", "replyContent", "getReplyContent", "Landroid/widget/FrameLayout;", "replyLayout", "Landroid/widget/FrameLayout;", "getReplyLayout", "()Landroid/widget/FrameLayout;", "Landroid/text/SpannableString;", "showContent", "Landroid/text/SpannableString;", "getShowContent", "()Landroid/text/SpannableString;", "setShowContent", "(Landroid/text/SpannableString;)V", "titleAreaExpandClickListener", "getTitleAreaExpandClickListener", "Lcom/baidu/tbadk/core/view/HeadImageView;", "userInfoAvatar", "Lcom/baidu/tbadk/core/view/HeadImageView;", "getUserInfoAvatar", "()Lcom/baidu/tbadk/core/view/HeadImageView;", "userInfoClickListener", "getUserInfoClickListener", "userInfoLayout", "getUserInfoLayout", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "userInfoName", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "getUserInfoName", "()Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "userInfoReplyTime", "getUserInfoReplyTime", "verticalVideoHeight", "getVerticalVideoHeight", "videoContainer", "getVideoContainer", "Lcom/baidu/tieba/play/FloatVideoContainer$VideoEvent;", "videoEventCallback", "Lcom/baidu/tieba/play/FloatVideoContainer$VideoEvent;", "getVideoEventCallback", "()Lcom/baidu/tieba/play/FloatVideoContainer$VideoEvent;", "Landroid/widget/ImageView;", "videoInfoExpandTitleBtn", "Landroid/widget/ImageView;", "getVideoInfoExpandTitleBtn", "()Landroid/widget/ImageView;", "videoInfoExpandTitleBtnWrapper", "getVideoInfoExpandTitleBtnWrapper", "videoInfoLayout", "getVideoInfoLayout", "videoInfoPlayCount", "getVideoInfoPlayCount", "videoInfoTitle", "getVideoInfoTitle", "videoInfoTitleMaxLength", "getVideoInfoTitleMaxLength", "videoLayout", "getVideoLayout", "Lcom/baidu/tieba/play/operableVideoView/OperableVideoNetworkStateTipView;", "videoNetworkStateTip", "Lcom/baidu/tieba/play/operableVideoView/OperableVideoNetworkStateTipView;", "getVideoNetworkStateTip", "()Lcom/baidu/tieba/play/operableVideoView/OperableVideoNetworkStateTipView;", "Lcom/baidu/tieba/play/FloatVideoContainer$VideoStatisticCallback;", "videoStatisticCallback", "Lcom/baidu/tieba/play/FloatVideoContainer$VideoStatisticCallback;", "getVideoStatisticCallback", "()Lcom/baidu/tieba/play/FloatVideoContainer$VideoStatisticCallback;", "videoTitleExpandMaxLines", "getVideoTitleExpandMaxLines", "videoTitleFoldMaxLines", "getVideoTitleFoldMaxLines", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "viewModel", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "getViewModel", "()Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "<init>", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;)V", "Companion", "frsExtra_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class VideoMiddlePageLightCardView extends c.a.r0.a0.b<c.a.r0.w0.h1.g> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RelativeLayout A;
    public final HeadImageView B;
    public final EMTextView C;
    public final TextView D;
    public final View.OnClickListener E;
    public final FrameLayout F;
    public final FrameLayout G;
    public final c.a.r0.p2.c H;
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
    public c.a.r0.w0.h1.g o;
    public d2 p;
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

    /* loaded from: classes7.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f51687e;

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
            this.f51687e = videoMiddlePageLightCardView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g.c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51687e.U().setVisibility(8);
                this.f51687e.U().setHasAgreeToPlay(true);
                this.f51687e.R().k2();
                this.f51687e.R().n1(false);
                c.a.r0.w0.h1.g N = this.f51687e.N();
                if ((N != null ? N.z : null) != null) {
                    c.a.r0.p2.c R = this.f51687e.R();
                    c.a.r0.w0.h1.g N2 = this.f51687e.N();
                    String str = (N2 == null || (cVar = N2.z) == null) ? null : cVar.f26832d;
                    c.a.r0.w0.h1.g N3 = this.f51687e.N();
                    R.d2(str, N3 != null ? N3.f26804f : null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements Observer<Configuration> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f51688e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f51689f;

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
            this.f51688e = videoMiddlePageLightCardView;
            this.f51689f = tbPageContext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(Configuration configuration) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, configuration) == null) {
                Integer value = this.f51688e.V().getCurPlayingVideoPos().getValue();
                int O = this.f51688e.O();
                if (value != null && value.intValue() == O) {
                    int P = this.f51688e.P();
                    int i2 = configuration.orientation;
                    if (P != i2) {
                        if (i2 == 2) {
                            this.f51688e.J(this.f51689f);
                        } else {
                            this.f51688e.K(this.f51689f);
                        }
                        this.f51688e.R().V0(this.f51689f, configuration);
                        this.f51688e.Z(configuration.orientation);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f51690e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f51691f;

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
            this.f51690e = videoMiddlePageLightCardView;
            this.f51691f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f51690e.N() == null) {
                return;
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f51690e.f15550g);
            c.a.r0.w0.h1.g N = this.f51690e.N();
            pbActivityConfig.createNormalCfg(N != null ? N.f26804f : null, null, null);
            pbActivityConfig.setVideo_source("auto_midpage");
            c.a.r0.w0.h1.g N2 = this.f51690e.N();
            pbActivityConfig.setBjhData(N2 != null ? N2.A : null);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            d2 S = this.f51690e.S();
            c.a.r0.w0.h1.g N3 = this.f51690e.N();
            c.a.r0.i3.c.g().c(this.f51691f.getUniqueId(), c.a.r0.i3.a.d(S, "a023", "common_click", 1, N3 != null ? N3.I : 0, false, null, null));
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f51692e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f51693f;

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
            this.f51692e = videoMiddlePageLightCardView;
            this.f51693f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            c.a.r0.w0.h1.g N;
            z1 z1Var;
            String str;
            z1 z1Var2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (N = this.f51692e.N()) == null || (z1Var = N.B) == null || (str = z1Var.f14374b) == null) {
                return;
            }
            if (str.length() > 0) {
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.f51692e.d());
                c.a.r0.w0.h1.g N2 = this.f51692e.N();
                FrsActivityConfig createNormalCfg = frsActivityConfig.createNormalCfg((N2 == null || (z1Var2 = N2.B) == null) ? null : z1Var2.f14374b, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                d2 S = this.f51692e.S();
                c.a.r0.w0.h1.g N3 = this.f51692e.N();
                c.a.r0.i3.c.g().c(this.f51693f.getUniqueId(), c.a.r0.i3.a.d(S, "a023", "common_click", 9, N3 != null ? N3.I : 0, false, null, null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements c.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f51694a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f51695b;

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
            this.f51694a = videoMiddlePageLightCardView;
            this.f51695b = tbPageContext;
        }

        @Override // c.a.r0.p2.c.x
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f51694a.W()) {
                this.f51694a.J(this.f51695b);
            }
        }

        @Override // c.a.r0.p2.c.x
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f51694a.W()) {
                this.f51694a.K(this.f51695b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f51696e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f51697f;

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
            this.f51696e = videoMiddlePageLightCardView;
            this.f51697f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            List<q> list;
            q qVar;
            z1 z1Var;
            List<q> list2;
            q qVar2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f51696e.N() == null) {
                return;
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f51696e.f15550g);
            c.a.r0.w0.h1.g N = this.f51696e.N();
            String str = null;
            String str2 = N != null ? N.f26804f : null;
            c.a.r0.w0.h1.g N2 = this.f51696e.N();
            PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(str2, (N2 == null || (list2 = N2.D) == null || (qVar2 = list2.get(0)) == null || (r2 = qVar2.f20878a) == null) ? "" : "", null);
            createNormalCfg.setStartFrom(24);
            c.a.r0.w0.h1.g N3 = this.f51696e.N();
            createNormalCfg.setForumId(N3 != null ? N3.f26803e : null);
            c.a.r0.w0.h1.g N4 = this.f51696e.N();
            createNormalCfg.setForumName((N4 == null || (z1Var = N4.B) == null) ? null : z1Var.f14374b);
            c.a.r0.w0.h1.g N5 = this.f51696e.N();
            if (N5 != null && (list = N5.D) != null && (qVar = list.get(0)) != null) {
                str = qVar.f20878a;
            }
            createNormalCfg.setHighLightPostId(str);
            createNormalCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            d2 S = this.f51696e.S();
            c.a.r0.w0.h1.g N6 = this.f51696e.N();
            c.a.r0.i3.c.g().c(this.f51697f.getUniqueId(), c.a.r0.i3.a.d(S, "a023", "common_click", 5, N6 != null ? N6.I : 0, false, null, null));
        }
    }

    /* loaded from: classes7.dex */
    public static final class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f51698e;

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
            this.f51698e = videoMiddlePageLightCardView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f51698e.Q() == 1) {
                    this.f51698e.z(2);
                } else if (this.f51698e.Q() == 2) {
                    this.f51698e.z(1);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f51699e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f51700f;

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
            this.f51699e = videoMiddlePageLightCardView;
            this.f51700f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g.b bVar;
            g.b bVar2;
            g.b bVar3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.r0.w0.h1.g N = this.f51699e.N();
                String str = null;
                String str2 = (N == null || (bVar3 = N.y) == null) ? null : bVar3.f26815a;
                c.a.r0.w0.h1.g N2 = this.f51699e.N();
                String str3 = (N2 == null || (bVar2 = N2.y) == null) ? null : bVar2.f26817c;
                if (str3 == null || StringsKt__StringsJVMKt.isBlank(str3)) {
                    c.a.r0.w0.h1.g N3 = this.f51699e.N();
                    if (N3 != null && (bVar = N3.y) != null) {
                        str = bVar.f26816b;
                    }
                    str3 = str;
                }
                if (str2 != null && (!StringsKt__StringsJVMKt.isBlank(str2)) && str3 != null && (!StringsKt__StringsJVMKt.isBlank(str3))) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f51699e.d(), str2, str3)));
                }
                d2 S = this.f51699e.S();
                c.a.r0.w0.h1.g N4 = this.f51699e.N();
                c.a.r0.i3.c.g().c(this.f51700f.getUniqueId(), c.a.r0.i3.a.d(S, "a023", "common_click", 2, N4 != null ? N4.I : 0, false, null, null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class i implements c.j0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f51701a;

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
            this.f51701a = videoMiddlePageLightCardView;
        }

        @Override // c.a.r0.p2.c.j0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.r0.p2.c.j0
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // c.a.r0.p2.c.j0
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // c.a.r0.p2.c.j0
        public void onPaused() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // c.a.r0.p2.c.j0
        public void onPlayEnd() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f51701a.P() == 1 && !this.f51701a.R().R0()) {
                this.f51701a.V().playNextVideo();
            }
        }

        @Override // c.a.r0.p2.c.j0
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // c.a.r0.p2.c.j0
        public void onStarted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class j implements c.k0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageLightCardView f51702a;

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
            this.f51702a = videoMiddlePageLightCardView;
        }

        @Override // c.a.r0.p2.c.k0
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int O = this.f51702a.O();
                Integer value = this.f51702a.V().getCurPlayingVideoPos().getValue();
                if (value != null && O == value.intValue()) {
                    return;
                }
                this.f51702a.V().playVideoAtPosition(this.f51702a.O());
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
        View findViewById = j().findViewById(R.id.forum_info_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.forum_info_layout)");
        this.u = (RelativeLayout) findViewById;
        View findViewById2 = j().findViewById(R.id.forum_info_image);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.forum_info_image)");
        this.v = (BarImageView) findViewById2;
        View findViewById3 = j().findViewById(R.id.forum_info_barname);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "view.findViewById(R.id.forum_info_barname)");
        this.w = (SingleLineEllipsizeTextView) findViewById3;
        View findViewById4 = j().findViewById(R.id.forum_info_author);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "view.findViewById(R.id.forum_info_author)");
        this.x = (TextView) findViewById4;
        View findViewById5 = j().findViewById(R.id.forum_info_reply_time);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "view.findViewById(R.id.forum_info_reply_time)");
        this.y = (TextView) findViewById5;
        this.z = new d(this, tbPageContext);
        View findViewById6 = j().findViewById(R.id.user_info_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "view.findViewById(R.id.user_info_layout)");
        this.A = (RelativeLayout) findViewById6;
        View findViewById7 = j().findViewById(R.id.user_info_avatar);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, "view.findViewById(R.id.user_info_avatar)");
        this.B = (HeadImageView) findViewById7;
        View findViewById8 = j().findViewById(R.id.user_info_name);
        Intrinsics.checkExpressionValueIsNotNull(findViewById8, "view.findViewById(R.id.user_info_name)");
        this.C = (EMTextView) findViewById8;
        View findViewById9 = j().findViewById(R.id.user_info_reply_time);
        Intrinsics.checkExpressionValueIsNotNull(findViewById9, "view.findViewById(R.id.user_info_reply_time)");
        this.D = (TextView) findViewById9;
        this.E = new h(this, tbPageContext);
        View findViewById10 = j().findViewById(R.id.video_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById10, "view.findViewById(R.id.video_layout)");
        this.F = (FrameLayout) findViewById10;
        View findViewById11 = j().findViewById(R.id.video_container);
        Intrinsics.checkExpressionValueIsNotNull(findViewById11, "view.findViewById(R.id.video_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById11;
        this.G = frameLayout;
        this.H = new c.a.r0.p2.c(tbPageContext, frameLayout, false);
        View findViewById12 = j().findViewById(R.id.video_network_state_tip);
        Intrinsics.checkExpressionValueIsNotNull(findViewById12, "view.findViewById(R.id.video_network_state_tip)");
        this.I = (OperableVideoNetworkStateTipView) findViewById12;
        View findViewById13 = j().findViewById(R.id.video_info_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById13, "view.findViewById(R.id.video_info_layout)");
        this.J = (RelativeLayout) findViewById13;
        View findViewById14 = j().findViewById(R.id.video_info_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById14, "view.findViewById(R.id.video_info_title)");
        this.K = (TextView) findViewById14;
        this.M = 1;
        this.N = 3;
        this.O = (l.k(TbadkCoreApplication.getInst()) - this.J.getPaddingLeft()) - this.J.getPaddingRight();
        View findViewById15 = j().findViewById(R.id.video_info_expand_title_btn);
        Intrinsics.checkExpressionValueIsNotNull(findViewById15, "view.findViewById(R.id.v…eo_info_expand_title_btn)");
        this.P = (ImageView) findViewById15;
        View findViewById16 = j().findViewById(R.id.video_info_expand_title_btn_wrapper);
        Intrinsics.checkExpressionValueIsNotNull(findViewById16, "view.findViewById(R.id.v…expand_title_btn_wrapper)");
        this.Q = (RelativeLayout) findViewById16;
        View findViewById17 = j().findViewById(R.id.video_info_play_count);
        Intrinsics.checkExpressionValueIsNotNull(findViewById17, "view.findViewById(R.id.video_info_play_count)");
        this.R = (TextView) findViewById17;
        this.S = new g(this);
        View findViewById18 = j().findViewById(R.id.reply_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById18, "view.findViewById(R.id.reply_layout)");
        this.T = (FrameLayout) findViewById18;
        View findViewById19 = j().findViewById(R.id.reply_content);
        Intrinsics.checkExpressionValueIsNotNull(findViewById19, "view.findViewById(R.id.reply_content)");
        this.U = (TextView) findViewById19;
        this.V = "";
        this.W = "";
        this.Y = new f(this, tbPageContext);
        View findViewById20 = j().findViewById(R.id.op_layout);
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
        View view = j();
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
        MutableLiveData<Configuration> configuration = this.i0.getConfiguration();
        Activity pageActivity = tbPageContext.getPageActivity();
        if (pageActivity != null) {
            configuration.observe((LifecycleOwner) pageActivity, new b(this, tbPageContext));
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
            l(tbPageContext, inst.getSkinType());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.Q.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.P, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            this.K.setEllipsize(TextUtils.TruncateAt.END);
            this.K.setMaxLines(this.M);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.Q.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.P, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null);
            this.K.setEllipsize(null);
            this.K.setMaxLines(this.N);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.Q.setVisibility(8);
            this.K.setEllipsize(null);
            this.K.setMaxLines(this.M);
        }
    }

    public final void J(TbPageContext<?> tbPageContext) {
        Window window;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) {
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

    public final void K(TbPageContext<?> tbPageContext) {
        Window window;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
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

    public final o L(c.a.r0.w0.h1.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gVar)) == null) {
            o oVar = new o();
            oVar.f23808c = gVar.f26804f;
            oVar.t = gVar.f26805g;
            oVar.f23809d = gVar.f26803e;
            oVar.f23810e = TbadkCoreApplication.getCurrentAccount();
            oVar.f23806a = "13";
            oVar.f23811f = gVar.q;
            oVar.f23812g = gVar.r;
            oVar.f23814i = this.i0.getFrom();
            oVar.l = gVar.t;
            oVar.k = this.i0.getFromTid();
            oVar.o = gVar.s;
            oVar.p = this.s ? "1" : "0";
            oVar.f23815j = gVar.o();
            return oVar;
        }
        return (o) invokeL.objValue;
    }

    public final c.a.r0.w0.h1.g N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.o : (c.a.r0.w0.h1.g) invokeV.objValue;
    }

    public final int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.q : invokeV.intValue;
    }

    public final int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.r : invokeV.intValue;
    }

    public final int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.L : invokeV.intValue;
    }

    public final c.a.r0.p2.c R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.H : (c.a.r0.p2.c) invokeV.objValue;
    }

    public final d2 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.p : (d2) invokeV.objValue;
    }

    public final String T(List<? extends AbstractData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, list)) == null) {
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

    public final OperableVideoNetworkStateTipView U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.I : (OperableVideoNetworkStateTipView) invokeV.objValue;
    }

    public final VideoMiddlePageViewModel V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.i0 : (VideoMiddlePageViewModel) invokeV.objValue;
    }

    public final boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.s : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a0.b
    /* renamed from: X */
    public void k(c.a.r0.w0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gVar) == null) {
        }
    }

    public final void Y(c.a.r0.w0.h1.g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048593, this, gVar, i2) == null) || gVar == null) {
            return;
        }
        this.o = gVar;
        this.p = c.a.r0.w0.h1.g.g(gVar);
        this.q = i2;
        this.s = gVar.p();
        t(gVar);
        w(i2, gVar);
        x(gVar);
        v(gVar);
        u(gVar, this.p);
    }

    public final void Z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.r = i2;
        }
    }

    public final void a0(g.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, bVar) == null) || bVar == null) {
            return;
        }
        g.b.a aVar = bVar.f26822h;
        if (aVar != null && !TextUtils.isEmpty(aVar.f26824b)) {
            this.B.startLoad(bVar.f26822h.f26824b, 12, false);
        } else {
            if (!StringUtils.isNull(bVar.f26818d)) {
                String str = bVar.f26818d;
                Intrinsics.checkExpressionValueIsNotNull(str, "data.portrait");
                if (StringsKt__StringsJVMKt.startsWith$default(str, "http", false, 2, null)) {
                    this.B.startLoad(bVar.f26818d, 10, false);
                }
            }
            this.B.startLoad(bVar.f26818d, 12, false);
        }
        g.b.a aVar2 = bVar.f26822h;
        if (aVar2 != null && Intrinsics.compare(aVar2.f26827e.intValue(), 0) > 0) {
            Integer num = bVar.f26822h.f26827e;
            Intrinsics.checkExpressionValueIsNotNull(num, "data.baijiahaoData.auth_id");
            this.B.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(num.intValue(), 1));
            this.B.setShowV(true);
            this.B.setGodIconWidth(R.dimen.tbds31);
            return;
        }
        this.B.setBjhAuthIconRes(0);
        boolean z = bVar.f26821g;
        if (z) {
            this.B.setShowV(z);
            this.B.setIsBigV(bVar.f26821g);
        } else {
            boolean z2 = bVar.f26820f;
            if (z2) {
                this.B.setShowV(z2);
                this.B.setIsBigV(bVar.f26820f);
            } else {
                this.B.setShowV(z2);
                this.B.setIsBigV(bVar.f26820f);
            }
        }
        this.B.setGodIconWidth(R.dimen.tbds31);
    }

    @Override // c.a.r0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? R.layout.card_video_middle_page_light_layout : invokeV.intValue;
    }

    @Override // c.a.r0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(j(), R.color.CAM_X0201);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba16, SkinManager.getColor(R.color.CAM_X0105), null);
            int g2 = l.g(d(), R.dimen.tbds42);
            pureDrawable.setBounds(0, 0, g2, g2);
            this.w.setCompoundDrawables(null, null, pureDrawable, null);
            this.w.setCompoundDrawablePadding(l.g(d(), R.dimen.M_W_X002));
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.x, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.y, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.D, R.color.CAM_X0109);
            this.K.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            z(this.L);
            this.R.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.T);
            d2.o(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            y();
            this.Z.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view) == null) {
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.H.v0();
        }
    }

    public final void t(c.a.r0.w0.h1.g gVar) {
        z1 z1Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, gVar) == null) {
            String str2 = null;
            if (gVar.o() == 1 && (z1Var = gVar.B) != null && (str = z1Var.f14374b) != null && (!StringsKt__StringsJVMKt.isBlank(str))) {
                this.u.setVisibility(0);
                this.A.setVisibility(8);
                BarImageView barImageView = this.v;
                z1 z1Var2 = gVar.B;
                barImageView.startLoad(z1Var2 != null ? z1Var2.f14375c : null, 10, false);
                SingleLineEllipsizeTextView singleLineEllipsizeTextView = this.w;
                String string = d().getString(R.string.chosen_pb_original_bar);
                Object[] objArr = new Object[1];
                z1 z1Var3 = gVar.B;
                objArr[0] = z1Var3 != null ? z1Var3.f14374b : null;
                singleLineEllipsizeTextView.setText(String.format(string, objArr));
                TextView textView = this.x;
                StringBuilder sb = new StringBuilder();
                g.b bVar = gVar.y;
                if (TextUtils.isEmpty(bVar != null ? bVar.f26817c : null)) {
                    g.b bVar2 = gVar.y;
                    if (bVar2 != null) {
                        str2 = bVar2.f26816b;
                    }
                } else {
                    g.b bVar3 = gVar.y;
                    if (bVar3 != null) {
                        str2 = bVar3.f26817c;
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
            a0(bVar4);
            EMTextView eMTextView = this.C;
            g.b bVar5 = gVar.y;
            if (TextUtils.isEmpty(bVar5 != null ? bVar5.f26817c : null)) {
                g.b bVar6 = gVar.y;
                if (bVar6 != null) {
                    str2 = bVar6.f26816b;
                }
            } else {
                g.b bVar7 = gVar.y;
                if (bVar7 != null) {
                    str2 = bVar7.f26817c;
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

    public final boolean u(c.a.r0.w0.h1.g gVar, d2 d2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, gVar, d2Var)) == null) ? this.Z.setData(d2Var) : invokeLL.booleanValue;
    }

    public final void v(c.a.r0.w0.h1.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, gVar) == null) {
            List<q> list = gVar.D;
            if (list != null && !list.isEmpty()) {
                this.T.setVisibility(0);
                q qVar = gVar.D.get(0);
                MetaData metaData = qVar.f20879b;
                if (metaData == null || (string = metaData.getName_show()) == null) {
                    string = TbadkCoreApplication.getInst().getString(R.string.user_name_default_txt);
                    Intrinsics.checkExpressionValueIsNotNull(string, "TbadkCoreApplication.get…ng.user_name_default_txt)");
                }
                this.V = string;
                this.W = (char) 65306 + T(qVar.f20880c);
                this.X = new SpannableString(this.V + this.W);
                y();
                return;
            }
            this.T.setVisibility(8);
        }
    }

    public final void w(int i2, c.a.r0.w0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048604, this, i2, gVar) == null) || gVar.z == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
        if (layoutParams != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.height = this.s ? this.n : this.m;
            this.F.setLayoutParams(layoutParams2);
            this.H.L1(i2);
            this.H.S1(gVar.z.f26838j);
            this.H.W1(3);
            this.H.T1(gVar.z.f26833e);
            this.H.Y1(gVar.z.f26832d, gVar.f26804f);
            this.H.m1(gVar.f26803e);
            this.H.I0().setVideoStatData(L(gVar));
            this.H.a1();
            this.H.a2();
            this.I.setVideoLength(gVar.z.f26836h);
            this.I.setVideoDuration(gVar.z.f26833e);
            this.I.setTid(gVar.f26804f);
            if (gVar.F) {
                this.H.c2(false);
                if (this.I.isShowNetworkTips()) {
                    this.I.changeViewLayout(this.s, this.H.R0());
                    this.I.setVisibility(0);
                    this.H.n1(true);
                    return;
                }
                this.I.setVisibility(8);
                this.H.n1(false);
                this.H.d2(gVar.z.f26832d, gVar.f26804f);
                return;
            }
            this.I.setVisibility(8);
            this.H.k2();
            this.H.c2(true);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    public final void x(c.a.r0.w0.h1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, gVar) == null) {
            String str = gVar.x;
            if (str == null) {
                str = TbadkCoreApplication.getInst().getString(R.string.video_title_str);
                Intrinsics.checkExpressionValueIsNotNull(str, "TbadkCoreApplication.get…R.string.video_title_str)");
            }
            int i2 = 0;
            float measureText = this.K.getPaint().measureText(str, 0, str.length());
            float textSize = this.K.getTextSize();
            int i3 = this.M;
            if (measureText + (textSize * i3) > this.O * i3) {
                int i4 = this.L;
                i2 = (i4 == 1 || i4 == 2) ? this.L : 1;
            }
            z(i2);
            this.K.setText(str);
            TextView textView = this.R;
            textView.setText(StringHelper.numberUniformFormatExtra(gVar.f26808j) + TbadkCoreApplication.getInst().getString(R.string.play));
        }
    }

    public final void y() {
        SpannableString spannableString;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (!StringsKt__StringsJVMKt.isBlank(this.V))) {
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

    public final void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.L = i2;
            if (i2 == 0) {
                D();
            } else if (i2 == 1) {
                A();
            } else if (i2 != 2) {
            } else {
                B();
            }
        }
    }
}
