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
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import com.tencent.connect.common.Constants;
import d.b.c.e.p.l;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.w1;
import d.b.j0.d3.h0.p;
import d.b.j0.j2.c;
import d.b.j0.j2.o;
import d.b.j0.q0.i1.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Ø\u00012\u00020\u0001:\u0002Ø\u0001B\u001f\u0012\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001a\u0012\b\u0010Ò\u0001\u001a\u00030Ñ\u0001¢\u0006\u0006\bÖ\u0001\u0010×\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0013J\u001b\u0010\u001c\u001a\u00020\u00042\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u00042\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\rH\u0016¢\u0006\u0004\b\"\u0010#J\u001f\u0010(\u001a\u00020'2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b*\u0010\u0006J\u001f\u0010*\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b*\u0010+J#\u0010-\u001a\u00020\u00042\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010,\u001a\u00020\rH\u0016¢\u0006\u0004\b-\u0010.J\u0019\u00101\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0004H\u0016¢\u0006\u0004\b3\u0010\u0013J\u0017\u00105\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u000204H\u0002¢\u0006\u0004\b5\u00106R\u0019\u00108\u001a\u0002078\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R$\u0010<\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010\u0006R\"\u0010A\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010#\"\u0004\bD\u0010\u0016R\"\u0010E\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010B\u001a\u0004\bF\u0010#\"\u0004\bG\u0010\u0016R\"\u0010H\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010B\u001a\u0004\bI\u0010#\"\u0004\bJ\u0010\u0016R\u0019\u0010L\u001a\u00020K8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0019\u0010Q\u001a\u00020P8\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u0019\u0010V\u001a\u00020U8\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u0019\u0010Z\u001a\u0002078\u0006@\u0006¢\u0006\f\n\u0004\bZ\u00109\u001a\u0004\b[\u0010;R\u0019\u0010]\u001a\u00020\\8\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0019\u0010b\u001a\u00020a8\u0006@\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u0019\u0010f\u001a\u00020P8\u0006@\u0006¢\u0006\f\n\u0004\bf\u0010R\u001a\u0004\bg\u0010TR\u0019\u0010i\u001a\u00020h8\u0006@\u0006¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR$\u0010m\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u0019\u0010s\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\bs\u0010B\u001a\u0004\bt\u0010#R\"\u0010u\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bu\u0010w\"\u0004\bx\u0010yR\u0019\u0010{\u001a\u00020z8\u0006@\u0006¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R'\u0010\u007f\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R(\u0010\u0085\u0001\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0085\u0001\u0010\u0080\u0001\u001a\u0005\b(\u0010\u0082\u0001\"\u0006\b\u0086\u0001\u0010\u0084\u0001R\u001c\u0010\u0087\u0001\u001a\u0002078\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0087\u0001\u00109\u001a\u0005\b\u0088\u0001\u0010;R\u001c\u0010\u0089\u0001\u001a\u00020P8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0089\u0001\u0010R\u001a\u0005\b\u008a\u0001\u0010TR\u001f\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R,\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001c\u0010\u0097\u0001\u001a\u0002078\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0097\u0001\u00109\u001a\u0005\b\u0098\u0001\u0010;R\u001f\u0010\u009a\u0001\u001a\u00030\u0099\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001c\u0010\u009e\u0001\u001a\u0002078\u0006@\u0006¢\u0006\u000e\n\u0005\b\u009e\u0001\u00109\u001a\u0005\b\u009f\u0001\u0010;R\u001c\u0010 \u0001\u001a\u00020a8\u0006@\u0006¢\u0006\u000e\n\u0005\b \u0001\u0010c\u001a\u0005\b¡\u0001\u0010eR\u001f\u0010£\u0001\u001a\u00030¢\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001R\u001c\u0010§\u0001\u001a\u00020P8\u0006@\u0006¢\u0006\u000e\n\u0005\b§\u0001\u0010R\u001a\u0005\b¨\u0001\u0010TR\u001c\u0010©\u0001\u001a\u00020\r8\u0006@\u0006¢\u0006\u000e\n\u0005\b©\u0001\u0010B\u001a\u0005\bª\u0001\u0010#R\u001f\u0010«\u0001\u001a\u00030\u008b\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b«\u0001\u0010\u008d\u0001\u001a\u0006\b¬\u0001\u0010\u008f\u0001R\u001f\u0010®\u0001\u001a\u00030\u00ad\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b®\u0001\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001R\u001f\u0010³\u0001\u001a\u00030²\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001R\u001c\u0010·\u0001\u001a\u00020a8\u0006@\u0006¢\u0006\u000e\n\u0005\b·\u0001\u0010c\u001a\u0005\b¸\u0001\u0010eR\u001c\u0010¹\u0001\u001a\u00020a8\u0006@\u0006¢\u0006\u000e\n\u0005\b¹\u0001\u0010c\u001a\u0005\bº\u0001\u0010eR\u001c\u0010»\u0001\u001a\u00020P8\u0006@\u0006¢\u0006\u000e\n\u0005\b»\u0001\u0010R\u001a\u0005\b¼\u0001\u0010TR\u001c\u0010½\u0001\u001a\u00020P8\u0006@\u0006¢\u0006\u000e\n\u0005\b½\u0001\u0010R\u001a\u0005\b¾\u0001\u0010TR\u001c\u0010¿\u0001\u001a\u00020\r8\u0006@\u0006¢\u0006\u000e\n\u0005\b¿\u0001\u0010B\u001a\u0005\bÀ\u0001\u0010#R\u001f\u0010Á\u0001\u001a\u00030\u008b\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÁ\u0001\u0010\u008d\u0001\u001a\u0006\bÂ\u0001\u0010\u008f\u0001R\u001f\u0010Ä\u0001\u001a\u00030Ã\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u001f\u0010É\u0001\u001a\u00030È\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001R\u001f\u0010Í\u0001\u001a\u00020\r8\u0006@\u0006X\u0086D¢\u0006\u000e\n\u0005\bÍ\u0001\u0010B\u001a\u0005\bÎ\u0001\u0010#R\u001f\u0010Ï\u0001\u001a\u00020\r8\u0006@\u0006X\u0086D¢\u0006\u000e\n\u0005\bÏ\u0001\u0010B\u001a\u0005\bÐ\u0001\u0010#R\u001f\u0010Ò\u0001\u001a\u00030Ñ\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001¨\u0006Ù\u0001"}, d2 = {"Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageLightCardView;", "Ld/b/j0/x/b;", "Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;", "data", "", "bindHeadData", "(Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;)V", "Lcom/baidu/tbadk/core/data/ThreadData;", "threadData", "", "bindOpData", "(Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;Lcom/baidu/tbadk/core/data/ThreadData;)Z", "bindReplyData", "", "position", "bindVideoData", "(ILcom/baidu/tieba/frs/aggregation/VideoAggregationData;)V", "bindVideoInfoData", "changeReplyContentColor", "()V", "videoTitleStatus", "changeVideoTitleStatus", "(I)V", "changeVideoTitleStyleExpandBtnArrowDown", "changeVideoTitleStyleExpandBtnArrowUp", "changeVideoTitleStyleNoExpandBtn", "Lcom/baidu/tbadk/TbPageContext;", "pageContext", "enterFullScreen", "(Lcom/baidu/tbadk/TbPageContext;)V", "exitFullScreen", "Lcom/baidu/tieba/play/VideoStatsData;", "generateVideoStatsData", "(Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;)Lcom/baidu/tieba/play/VideoStatsData;", "getLayout", "()I", "", "Lcom/baidu/tbadk/core/data/AbstractData;", "abstractDataList", "", "getPostContent", "(Ljava/util/List;)Ljava/lang/String;", "onBindDataToView", "(Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;I)V", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(Lcom/baidu/tbadk/TbPageContext;I)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", MissionEvent.MESSAGE_DESTROY, "Lcom/baidu/tieba/frs/aggregation/VideoAggregationData$VideoAggregationAuthorData;", "setUserAvatar", "(Lcom/baidu/tieba/frs/aggregation/VideoAggregationData$VideoAggregationAuthorData;)V", "Landroid/view/View$OnClickListener;", "cardClickListener", "Landroid/view/View$OnClickListener;", "getCardClickListener", "()Landroid/view/View$OnClickListener;", "curData", "Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;", "getCurData", "()Lcom/baidu/tieba/frs/aggregation/VideoAggregationData;", "setCurData", "curPos", "I", "getCurPos", "setCurPos", "curScreenOrientation", "getCurScreenOrientation", "setCurScreenOrientation", "curVideoTitleStatus", "getCurVideoTitleStatus", "setCurVideoTitleStatus", "Lcom/baidu/tieba/play/FloatVideoContainer;", "floatVideoContainer", "Lcom/baidu/tieba/play/FloatVideoContainer;", "getFloatVideoContainer", "()Lcom/baidu/tieba/play/FloatVideoContainer;", "Landroid/widget/TextView;", "forumInfoAuthor", "Landroid/widget/TextView;", "getForumInfoAuthor", "()Landroid/widget/TextView;", "Lcom/baidu/tbadk/core/view/SingleLineEllipsizeTextView;", "forumInfoBarname", "Lcom/baidu/tbadk/core/view/SingleLineEllipsizeTextView;", "getForumInfoBarname", "()Lcom/baidu/tbadk/core/view/SingleLineEllipsizeTextView;", "forumInfoClickListener", "getForumInfoClickListener", "Lcom/baidu/tbadk/core/view/BarImageView;", "forumInfoImage", "Lcom/baidu/tbadk/core/view/BarImageView;", "getForumInfoImage", "()Lcom/baidu/tbadk/core/view/BarImageView;", "Landroid/widget/RelativeLayout;", "forumInfoLayout", "Landroid/widget/RelativeLayout;", "getForumInfoLayout", "()Landroid/widget/RelativeLayout;", "forumInfoReplyTime", "getForumInfoReplyTime", "Lcom/baidu/tieba/play/FloatVideoContainer$OnFullScreenStateListener;", "fullScreenStateListener", "Lcom/baidu/tieba/play/FloatVideoContainer$OnFullScreenStateListener;", "getFullScreenStateListener", "()Lcom/baidu/tieba/play/FloatVideoContainer$OnFullScreenStateListener;", "generateThreadData", "Lcom/baidu/tbadk/core/data/ThreadData;", "getGenerateThreadData", "()Lcom/baidu/tbadk/core/data/ThreadData;", "setGenerateThreadData", "(Lcom/baidu/tbadk/core/data/ThreadData;)V", "horizontalVideoHeight", "getHorizontalVideoHeight", "isVerticalVideo", "Z", "()Z", "setVerticalVideo", "(Z)V", "Lcom/baidu/tbadk/core/view/ThreadCardBottomOpSegmentLayout;", "opLayout", "Lcom/baidu/tbadk/core/view/ThreadCardBottomOpSegmentLayout;", "getOpLayout", "()Lcom/baidu/tbadk/core/view/ThreadCardBottomOpSegmentLayout;", "postAuthorName", "Ljava/lang/String;", "getPostAuthorName", "()Ljava/lang/String;", "setPostAuthorName", "(Ljava/lang/String;)V", "postContent", "setPostContent", "replyAreaClickListener", "getReplyAreaClickListener", "replyContent", "getReplyContent", "Landroid/widget/FrameLayout;", "replyLayout", "Landroid/widget/FrameLayout;", "getReplyLayout", "()Landroid/widget/FrameLayout;", "Landroid/text/SpannableString;", "showContent", "Landroid/text/SpannableString;", "getShowContent", "()Landroid/text/SpannableString;", "setShowContent", "(Landroid/text/SpannableString;)V", "titleAreaExpandClickListener", "getTitleAreaExpandClickListener", "Lcom/baidu/tbadk/core/view/HeadImageView;", "userInfoAvatar", "Lcom/baidu/tbadk/core/view/HeadImageView;", "getUserInfoAvatar", "()Lcom/baidu/tbadk/core/view/HeadImageView;", "userInfoClickListener", "getUserInfoClickListener", "userInfoLayout", "getUserInfoLayout", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "userInfoName", "Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "getUserInfoName", "()Lcom/baidu/tbadk/core/elementsMaven/view/EMTextView;", "userInfoReplyTime", "getUserInfoReplyTime", "verticalVideoHeight", "getVerticalVideoHeight", "videoContainer", "getVideoContainer", "Lcom/baidu/tieba/play/FloatVideoContainer$VideoEvent;", "videoEventCallback", "Lcom/baidu/tieba/play/FloatVideoContainer$VideoEvent;", "getVideoEventCallback", "()Lcom/baidu/tieba/play/FloatVideoContainer$VideoEvent;", "Landroid/widget/ImageView;", "videoInfoExpandTitleBtn", "Landroid/widget/ImageView;", "getVideoInfoExpandTitleBtn", "()Landroid/widget/ImageView;", "videoInfoExpandTitleBtnWrapper", "getVideoInfoExpandTitleBtnWrapper", "videoInfoLayout", "getVideoInfoLayout", "videoInfoPlayCount", "getVideoInfoPlayCount", "videoInfoTitle", "getVideoInfoTitle", "videoInfoTitleMaxLength", "getVideoInfoTitleMaxLength", "videoLayout", "getVideoLayout", "Lcom/baidu/tieba/play/operableVideoView/OperableVideoNetworkStateTipView;", "videoNetworkStateTip", "Lcom/baidu/tieba/play/operableVideoView/OperableVideoNetworkStateTipView;", "getVideoNetworkStateTip", "()Lcom/baidu/tieba/play/operableVideoView/OperableVideoNetworkStateTipView;", "Lcom/baidu/tieba/play/FloatVideoContainer$VideoStatisticCallback;", "videoStatisticCallback", "Lcom/baidu/tieba/play/FloatVideoContainer$VideoStatisticCallback;", "getVideoStatisticCallback", "()Lcom/baidu/tieba/play/FloatVideoContainer$VideoStatisticCallback;", "videoTitleExpandMaxLines", "getVideoTitleExpandMaxLines", "videoTitleFoldMaxLines", "getVideoTitleFoldMaxLines", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "viewModel", "Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "getViewModel", "()Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "<init>", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;)V", "Companion", "frsExtra_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class VideoMiddlePageLightCardView extends d.b.j0.x.b<d.b.j0.q0.i1.g> {
    public final RelativeLayout A;
    public final HeadImageView B;
    public final EMTextView C;
    public final TextView D;
    public final View.OnClickListener E;
    public final FrameLayout F;
    public final FrameLayout G;
    public final d.b.j0.j2.c H;
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
    public final VideoMiddlePageViewModel d0;
    public final int m;
    public final int n;
    public d.b.j0.q0.i1.g o;
    public a2 p;
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
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g.c cVar;
            VideoMiddlePageLightCardView.this.V().setVisibility(8);
            VideoMiddlePageLightCardView.this.V().setHasAgreeToPlay(true);
            VideoMiddlePageLightCardView.this.S().k2();
            VideoMiddlePageLightCardView.this.S().n1(false);
            d.b.j0.q0.i1.g O = VideoMiddlePageLightCardView.this.O();
            if ((O != null ? O.z : null) != null) {
                d.b.j0.j2.c S = VideoMiddlePageLightCardView.this.S();
                d.b.j0.q0.i1.g O2 = VideoMiddlePageLightCardView.this.O();
                String str = (O2 == null || (cVar = O2.z) == null) ? null : cVar.f59766d;
                d.b.j0.q0.i1.g O3 = VideoMiddlePageLightCardView.this.O();
                S.d2(str, O3 != null ? O3.f59740f : null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b<T> implements Observer<Configuration> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16362b;

        public b(TbPageContext tbPageContext) {
            this.f16362b = tbPageContext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(Configuration configuration) {
            Integer value = VideoMiddlePageLightCardView.this.W().c().getValue();
            int P = VideoMiddlePageLightCardView.this.P();
            if (value != null && value.intValue() == P) {
                int Q = VideoMiddlePageLightCardView.this.Q();
                int i = configuration.orientation;
                if (Q != i) {
                    if (i == 2) {
                        VideoMiddlePageLightCardView.this.K(this.f16362b);
                    } else {
                        VideoMiddlePageLightCardView.this.L(this.f16362b);
                    }
                    VideoMiddlePageLightCardView.this.S().V0(this.f16362b, configuration);
                    VideoMiddlePageLightCardView.this.c0(configuration.orientation);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16364f;

        public c(TbPageContext tbPageContext) {
            this.f16364f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (VideoMiddlePageLightCardView.this.O() == null) {
                return;
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(VideoMiddlePageLightCardView.this.f64178g);
            d.b.j0.q0.i1.g O = VideoMiddlePageLightCardView.this.O();
            pbActivityConfig.createNormalCfg(O != null ? O.f59740f : null, null, null);
            pbActivityConfig.setVideo_source("auto_midpage");
            d.b.j0.q0.i1.g O2 = VideoMiddlePageLightCardView.this.O();
            pbActivityConfig.setBjhData(O2 != null ? O2.A : null);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            a2 T = VideoMiddlePageLightCardView.this.T();
            d.b.j0.q0.i1.g O3 = VideoMiddlePageLightCardView.this.O();
            d.b.j0.c3.c.g().c(this.f16364f.getUniqueId(), d.b.j0.c3.a.d(T, "a023", "common_click", 1, O3 != null ? O3.I : 0, false, null, null));
        }
    }

    /* loaded from: classes4.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16366f;

        public d(TbPageContext tbPageContext) {
            this.f16366f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            w1 w1Var;
            String str;
            w1 w1Var2;
            d.b.j0.q0.i1.g O = VideoMiddlePageLightCardView.this.O();
            if (O == null || (w1Var = O.B) == null || (str = w1Var.f51660b) == null) {
                return;
            }
            if (str.length() > 0) {
                FrsActivityConfig frsActivityConfig = new FrsActivityConfig(VideoMiddlePageLightCardView.this.b());
                d.b.j0.q0.i1.g O2 = VideoMiddlePageLightCardView.this.O();
                FrsActivityConfig createNormalCfg = frsActivityConfig.createNormalCfg((O2 == null || (w1Var2 = O2.B) == null) ? null : w1Var2.f51660b, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                a2 T = VideoMiddlePageLightCardView.this.T();
                d.b.j0.q0.i1.g O3 = VideoMiddlePageLightCardView.this.O();
                d.b.j0.c3.c.g().c(this.f16366f.getUniqueId(), d.b.j0.c3.a.d(T, "a023", "common_click", 9, O3 != null ? O3.I : 0, false, null, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class e implements c.x {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16368b;

        public e(TbPageContext tbPageContext) {
            this.f16368b = tbPageContext;
        }

        @Override // d.b.j0.j2.c.x
        public void a() {
            if (VideoMiddlePageLightCardView.this.X()) {
                VideoMiddlePageLightCardView.this.K(this.f16368b);
            }
        }

        @Override // d.b.j0.j2.c.x
        public void b() {
            if (VideoMiddlePageLightCardView.this.X()) {
                VideoMiddlePageLightCardView.this.L(this.f16368b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class f implements View.OnClickListener {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16370f;

        public f(TbPageContext tbPageContext) {
            this.f16370f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            List<p> list;
            p pVar;
            w1 w1Var;
            List<p> list2;
            p pVar2;
            if (VideoMiddlePageLightCardView.this.O() == null) {
                return;
            }
            PbActivityConfig pbActivityConfig = new PbActivityConfig(VideoMiddlePageLightCardView.this.f64178g);
            d.b.j0.q0.i1.g O = VideoMiddlePageLightCardView.this.O();
            String str = null;
            String str2 = O != null ? O.f59740f : null;
            d.b.j0.q0.i1.g O2 = VideoMiddlePageLightCardView.this.O();
            PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(str2, (O2 == null || (list2 = O2.D) == null || (pVar2 = list2.get(0)) == null || (r2 = pVar2.f55276a) == null) ? "" : "", null);
            createNormalCfg.setStartFrom(24);
            d.b.j0.q0.i1.g O3 = VideoMiddlePageLightCardView.this.O();
            createNormalCfg.setForumId(O3 != null ? O3.f59739e : null);
            d.b.j0.q0.i1.g O4 = VideoMiddlePageLightCardView.this.O();
            createNormalCfg.setForumName((O4 == null || (w1Var = O4.B) == null) ? null : w1Var.f51660b);
            d.b.j0.q0.i1.g O5 = VideoMiddlePageLightCardView.this.O();
            if (O5 != null && (list = O5.D) != null && (pVar = list.get(0)) != null) {
                str = pVar.f55276a;
            }
            createNormalCfg.setHighLightPostId(str);
            createNormalCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            a2 T = VideoMiddlePageLightCardView.this.T();
            d.b.j0.q0.i1.g O6 = VideoMiddlePageLightCardView.this.O();
            d.b.j0.c3.c.g().c(this.f16370f.getUniqueId(), d.b.j0.c3.a.d(T, "a023", "common_click", 5, O6 != null ? O6.I : 0, false, null, null));
        }
    }

    /* loaded from: classes4.dex */
    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (VideoMiddlePageLightCardView.this.R() == 1) {
                VideoMiddlePageLightCardView.this.F(2);
            } else if (VideoMiddlePageLightCardView.this.R() == 2) {
                VideoMiddlePageLightCardView.this.F(1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class h implements View.OnClickListener {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16373f;

        public h(TbPageContext tbPageContext) {
            this.f16373f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g.b bVar;
            g.b bVar2;
            g.b bVar3;
            d.b.j0.q0.i1.g O = VideoMiddlePageLightCardView.this.O();
            String str = null;
            String str2 = (O == null || (bVar3 = O.y) == null) ? null : bVar3.f59749a;
            d.b.j0.q0.i1.g O2 = VideoMiddlePageLightCardView.this.O();
            String str3 = (O2 == null || (bVar2 = O2.y) == null) ? null : bVar2.f59751c;
            if (str3 == null || StringsKt__StringsJVMKt.isBlank(str3)) {
                d.b.j0.q0.i1.g O3 = VideoMiddlePageLightCardView.this.O();
                if (O3 != null && (bVar = O3.y) != null) {
                    str = bVar.f59750b;
                }
                str3 = str;
            }
            if (str2 != null && (!StringsKt__StringsJVMKt.isBlank(str2)) && str3 != null && (!StringsKt__StringsJVMKt.isBlank(str3))) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(VideoMiddlePageLightCardView.this.b(), str2, str3)));
            }
            a2 T = VideoMiddlePageLightCardView.this.T();
            d.b.j0.q0.i1.g O4 = VideoMiddlePageLightCardView.this.O();
            d.b.j0.c3.c.g().c(this.f16373f.getUniqueId(), d.b.j0.c3.a.d(T, "a023", "common_click", 2, O4 != null ? O4.I : 0, false, null, null));
        }
    }

    /* loaded from: classes4.dex */
    public static final class i implements c.j0 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public i() {
        }

        @Override // d.b.j0.j2.c.j0
        public void a() {
        }

        @Override // d.b.j0.j2.c.j0
        public void b() {
        }

        @Override // d.b.j0.j2.c.j0
        public void c() {
            if (VideoMiddlePageLightCardView.this.Q() != 1 || VideoMiddlePageLightCardView.this.S().R0()) {
                return;
            }
            VideoMiddlePageLightCardView.this.W().n();
        }

        @Override // d.b.j0.j2.c.j0
        public void d(int i) {
        }

        @Override // d.b.j0.j2.c.j0
        public void onPaused() {
        }

        @Override // d.b.j0.j2.c.j0
        public void onPrepared() {
        }

        @Override // d.b.j0.j2.c.j0
        public void onStarted() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class j implements c.k0 {
        public j() {
        }

        @Override // d.b.j0.j2.c.k0
        public final void a() {
            int P = VideoMiddlePageLightCardView.this.P();
            Integer value = VideoMiddlePageLightCardView.this.W().c().getValue();
            if (value != null && P == value.intValue()) {
                return;
            }
            VideoMiddlePageLightCardView.this.W().o(VideoMiddlePageLightCardView.this.P());
        }
    }

    public VideoMiddlePageLightCardView(TbPageContext<?> tbPageContext, VideoMiddlePageViewModel videoMiddlePageViewModel) {
        super(tbPageContext);
        this.d0 = videoMiddlePageViewModel;
        this.m = (int) (l.k(tbPageContext.getPageActivity()) * 0.5625d);
        this.n = (int) (l.k(tbPageContext.getPageActivity()) * 1.0d);
        this.r = 1;
        this.t = new c(tbPageContext);
        View findViewById = m().findViewById(R.id.forum_info_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.forum_info_layout)");
        this.u = (RelativeLayout) findViewById;
        View findViewById2 = m().findViewById(R.id.forum_info_image);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.forum_info_image)");
        this.v = (BarImageView) findViewById2;
        View findViewById3 = m().findViewById(R.id.forum_info_barname);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "view.findViewById(R.id.forum_info_barname)");
        this.w = (SingleLineEllipsizeTextView) findViewById3;
        View findViewById4 = m().findViewById(R.id.forum_info_author);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "view.findViewById(R.id.forum_info_author)");
        this.x = (TextView) findViewById4;
        View findViewById5 = m().findViewById(R.id.forum_info_reply_time);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "view.findViewById(R.id.forum_info_reply_time)");
        this.y = (TextView) findViewById5;
        this.z = new d(tbPageContext);
        View findViewById6 = m().findViewById(R.id.user_info_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "view.findViewById(R.id.user_info_layout)");
        this.A = (RelativeLayout) findViewById6;
        View findViewById7 = m().findViewById(R.id.user_info_avatar);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, "view.findViewById(R.id.user_info_avatar)");
        this.B = (HeadImageView) findViewById7;
        View findViewById8 = m().findViewById(R.id.user_info_name);
        Intrinsics.checkExpressionValueIsNotNull(findViewById8, "view.findViewById(R.id.user_info_name)");
        this.C = (EMTextView) findViewById8;
        View findViewById9 = m().findViewById(R.id.user_info_reply_time);
        Intrinsics.checkExpressionValueIsNotNull(findViewById9, "view.findViewById(R.id.user_info_reply_time)");
        this.D = (TextView) findViewById9;
        this.E = new h(tbPageContext);
        View findViewById10 = m().findViewById(R.id.video_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById10, "view.findViewById(R.id.video_layout)");
        this.F = (FrameLayout) findViewById10;
        View findViewById11 = m().findViewById(R.id.video_container);
        Intrinsics.checkExpressionValueIsNotNull(findViewById11, "view.findViewById(R.id.video_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById11;
        this.G = frameLayout;
        this.H = new d.b.j0.j2.c(tbPageContext, frameLayout, false);
        View findViewById12 = m().findViewById(R.id.video_network_state_tip);
        Intrinsics.checkExpressionValueIsNotNull(findViewById12, "view.findViewById(R.id.video_network_state_tip)");
        this.I = (OperableVideoNetworkStateTipView) findViewById12;
        View findViewById13 = m().findViewById(R.id.video_info_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById13, "view.findViewById(R.id.video_info_layout)");
        this.J = (RelativeLayout) findViewById13;
        View findViewById14 = m().findViewById(R.id.video_info_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById14, "view.findViewById(R.id.video_info_title)");
        this.K = (TextView) findViewById14;
        this.M = 1;
        this.N = 3;
        this.O = (l.k(TbadkCoreApplication.getInst()) - this.J.getPaddingLeft()) - this.J.getPaddingRight();
        View findViewById15 = m().findViewById(R.id.video_info_expand_title_btn);
        Intrinsics.checkExpressionValueIsNotNull(findViewById15, "view.findViewById(R.id.v…eo_info_expand_title_btn)");
        this.P = (ImageView) findViewById15;
        View findViewById16 = m().findViewById(R.id.video_info_expand_title_btn_wrapper);
        Intrinsics.checkExpressionValueIsNotNull(findViewById16, "view.findViewById(R.id.v…expand_title_btn_wrapper)");
        this.Q = (RelativeLayout) findViewById16;
        View findViewById17 = m().findViewById(R.id.video_info_play_count);
        Intrinsics.checkExpressionValueIsNotNull(findViewById17, "view.findViewById(R.id.video_info_play_count)");
        this.R = (TextView) findViewById17;
        this.S = new g();
        View findViewById18 = m().findViewById(R.id.reply_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById18, "view.findViewById(R.id.reply_layout)");
        this.T = (FrameLayout) findViewById18;
        View findViewById19 = m().findViewById(R.id.reply_content);
        Intrinsics.checkExpressionValueIsNotNull(findViewById19, "view.findViewById(R.id.reply_content)");
        this.U = (TextView) findViewById19;
        this.V = "";
        this.W = "";
        this.Y = new f(tbPageContext);
        View findViewById20 = m().findViewById(R.id.op_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById20, "view.findViewById(R.id.op_layout)");
        this.Z = (ThreadCardBottomOpSegmentLayout) findViewById20;
        this.a0 = new j();
        this.b0 = new e(tbPageContext);
        this.c0 = new i();
        this.u.setOnClickListener(this.z);
        this.v.setShowOval(true);
        this.v.setAutoChangeStyle(true);
        this.v.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.v.setStrokeColorResId(R.color.CAM_X0401);
        this.v.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.v.setPlaceHolder(1);
        this.v.setOnClickListener(this.z);
        SingleLineEllipsizeTextView singleLineEllipsizeTextView = this.w;
        View view = m();
        Intrinsics.checkExpressionValueIsNotNull(view, "view");
        singleLineEllipsizeTextView.setEllipsisSuffix(view.getResources().getString(R.string.ellipsis_suffix_bar));
        this.w.setOnClickListener(this.z);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        this.w.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
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
        this.I.setPlayViewOnClickListener(new a());
        MutableLiveData<Configuration> b2 = this.d0.b();
        Activity pageActivity = tbPageContext.getPageActivity();
        if (pageActivity != null) {
            b2.observe((LifecycleOwner) pageActivity, new b(tbPageContext));
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
            o(tbPageContext, inst.getSkinType());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    public final void A(int i2, d.b.j0.q0.i1.g gVar) {
        if (gVar.z == null) {
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
            this.H.T1(gVar.z.f59767e);
            this.H.Y1(gVar.z.f59766d, gVar.f59740f);
            this.H.m1(gVar.f59739e);
            this.H.I0().setVideoStatData(M(gVar));
            this.H.a1();
            this.H.a2();
            this.I.setVideoLength(gVar.z.f59770h);
            this.I.setVideoDuration(gVar.z.f59767e);
            this.I.setTid(gVar.f59740f);
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
                this.H.d2(gVar.z.f59766d, gVar.f59740f);
                return;
            }
            this.I.setVisibility(8);
            this.H.k2();
            this.H.c2(true);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    public final void B(d.b.j0.q0.i1.g gVar) {
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
        F(i2);
        this.K.setText(str);
        TextView textView = this.R;
        textView.setText(StringHelper.numberUniformFormatExtra(gVar.j) + TbadkCoreApplication.getInst().getString(R.string.play));
    }

    public final void E() {
        SpannableString spannableString;
        if (!StringsKt__StringsJVMKt.isBlank(this.V)) {
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

    public final void F(int i2) {
        this.L = i2;
        if (i2 == 0) {
            J();
        } else if (i2 == 1) {
            G();
        } else if (i2 != 2) {
        } else {
            I();
        }
    }

    public final void G() {
        this.Q.setVisibility(0);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.P, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
        this.K.setEllipsize(TextUtils.TruncateAt.END);
        this.K.setMaxLines(this.M);
    }

    public final void I() {
        this.Q.setVisibility(0);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.P, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null);
        this.K.setEllipsize(null);
        this.K.setMaxLines(this.N);
    }

    public final void J() {
        this.Q.setVisibility(8);
        this.K.setEllipsize(null);
        this.K.setMaxLines(this.M);
    }

    public final void K(TbPageContext<?> tbPageContext) {
        Window window;
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

    public final void L(TbPageContext<?> tbPageContext) {
        Window window;
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

    public final o M(d.b.j0.q0.i1.g gVar) {
        o oVar = new o();
        oVar.f58034c = gVar.f59740f;
        oVar.t = gVar.f59741g;
        oVar.f58035d = gVar.f59739e;
        oVar.f58036e = TbadkCoreApplication.getCurrentAccount();
        oVar.f58032a = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
        oVar.f58037f = gVar.q;
        oVar.f58038g = gVar.r;
        oVar.i = this.d0.d();
        oVar.l = gVar.t;
        oVar.k = this.d0.e();
        oVar.o = gVar.s;
        oVar.p = this.s ? "1" : "0";
        oVar.j = gVar.o();
        return oVar;
    }

    public final d.b.j0.q0.i1.g O() {
        return this.o;
    }

    public final int P() {
        return this.q;
    }

    public final int Q() {
        return this.r;
    }

    public final int R() {
        return this.L;
    }

    public final d.b.j0.j2.c S() {
        return this.H;
    }

    public final a2 T() {
        return this.p;
    }

    public final String U(List<? extends AbstractData> list) {
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

    public final OperableVideoNetworkStateTipView V() {
        return this.I;
    }

    public final VideoMiddlePageViewModel W() {
        return this.d0;
    }

    public final boolean X() {
        return this.s;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
    /* renamed from: Y */
    public void n(d.b.j0.q0.i1.g gVar) {
    }

    public final void b0(d.b.j0.q0.i1.g gVar, int i2) {
        if (gVar == null) {
            return;
        }
        this.o = gVar;
        this.p = d.b.j0.q0.i1.g.g(gVar);
        this.q = i2;
        this.s = gVar.s();
        x(gVar);
        A(i2, gVar);
        B(gVar);
        z(gVar);
        y(gVar, this.p);
    }

    public final void c0(int i2) {
        this.r = i2;
    }

    public final void d0(g.b bVar) {
        if (bVar == null) {
            return;
        }
        g.b.a aVar = bVar.f59756h;
        if (aVar != null && !TextUtils.isEmpty(aVar.f59758b)) {
            this.B.W(bVar.f59756h.f59758b, 12, false);
        } else {
            if (!StringUtils.isNull(bVar.f59752d)) {
                String str = bVar.f59752d;
                Intrinsics.checkExpressionValueIsNotNull(str, "data.portrait");
                if (StringsKt__StringsJVMKt.startsWith$default(str, "http", false, 2, null)) {
                    this.B.W(bVar.f59752d, 10, false);
                }
            }
            this.B.W(bVar.f59752d, 12, false);
        }
        g.b.a aVar2 = bVar.f59756h;
        if (aVar2 != null && Intrinsics.compare(aVar2.f59761e.intValue(), 0) > 0) {
            Integer num = bVar.f59756h.f59761e;
            Intrinsics.checkExpressionValueIsNotNull(num, "data.baijiahaoData.auth_id");
            this.B.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(num.intValue(), 1));
            this.B.setShowV(true);
            this.B.setGodIconWidth(R.dimen.tbds31);
            return;
        }
        this.B.setBjhAuthIconRes(0);
        boolean z = bVar.f59755g;
        if (z) {
            this.B.setShowV(z);
            this.B.setIsBigV(bVar.f59755g);
        } else {
            boolean z2 = bVar.f59754f;
            if (z2) {
                this.B.setShowV(z2);
                this.B.setIsBigV(bVar.f59754f);
            } else {
                this.B.setShowV(z2);
                this.B.setIsBigV(bVar.f59754f);
            }
        }
        this.B.setGodIconWidth(R.dimen.tbds31);
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.card_video_middle_page_light_layout;
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setBackgroundColor(m(), R.color.CAM_X0201);
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
        F(this.L);
        this.R.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
        d.b.i0.r.u.c d2 = d.b.i0.r.u.c.d(this.T);
        d2.k(R.string.J_X05);
        d2.f(R.color.CAM_X0206);
        E();
        this.Z.onChangeSkinType();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void onDestroy() {
        this.H.v0();
    }

    public final void x(d.b.j0.q0.i1.g gVar) {
        w1 w1Var;
        String str;
        String str2 = null;
        if (gVar.o() == 1 && (w1Var = gVar.B) != null && (str = w1Var.f51660b) != null && (!StringsKt__StringsJVMKt.isBlank(str))) {
            this.u.setVisibility(0);
            this.A.setVisibility(8);
            BarImageView barImageView = this.v;
            w1 w1Var2 = gVar.B;
            barImageView.W(w1Var2 != null ? w1Var2.f51661c : null, 10, false);
            SingleLineEllipsizeTextView singleLineEllipsizeTextView = this.w;
            String string = b().getString(R.string.chosen_pb_original_bar);
            Object[] objArr = new Object[1];
            w1 w1Var3 = gVar.B;
            objArr[0] = w1Var3 != null ? w1Var3.f51660b : null;
            singleLineEllipsizeTextView.setText(String.format(string, objArr));
            TextView textView = this.x;
            StringBuilder sb = new StringBuilder();
            g.b bVar = gVar.y;
            if (TextUtils.isEmpty(bVar != null ? bVar.f59751c : null)) {
                g.b bVar2 = gVar.y;
                if (bVar2 != null) {
                    str2 = bVar2.f59750b;
                }
            } else {
                g.b bVar3 = gVar.y;
                if (bVar3 != null) {
                    str2 = bVar3.f59751c;
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
        d0(bVar4);
        EMTextView eMTextView = this.C;
        g.b bVar5 = gVar.y;
        if (TextUtils.isEmpty(bVar5 != null ? bVar5.f59751c : null)) {
            g.b bVar6 = gVar.y;
            if (bVar6 != null) {
                str2 = bVar6.f59750b;
            }
        } else {
            g.b bVar7 = gVar.y;
            if (bVar7 != null) {
                str2 = bVar7.f59751c;
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

    public final boolean y(d.b.j0.q0.i1.g gVar, a2 a2Var) {
        return this.Z.setData(a2Var);
    }

    public final void z(d.b.j0.q0.i1.g gVar) {
        String string;
        List<p> list = gVar.D;
        if (list != null && !list.isEmpty()) {
            this.T.setVisibility(0);
            p pVar = gVar.D.get(0);
            MetaData metaData = pVar.f55277b;
            if (metaData == null || (string = metaData.getName_show()) == null) {
                string = TbadkCoreApplication.getInst().getString(R.string.user_name_default_txt);
                Intrinsics.checkExpressionValueIsNotNull(string, "TbadkCoreApplication.get…ng.user_name_default_txt)");
            }
            this.V = string;
            this.W = (char) 65306 + U(pVar.f55278c);
            this.X = new SpannableString(this.V + this.W);
            E();
            return;
        }
        this.T.setVisibility(8);
    }
}
