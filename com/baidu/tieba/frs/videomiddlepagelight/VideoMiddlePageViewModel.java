package com.baidu.tieba.frs.videomiddlepagelight;

import android.content.res.Configuration;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.videomiddlepage.VideoMiddleModel;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 H2\u00020\u0001:\u0001HB\u0013\u0012\n\u00102\u001a\u0006\u0012\u0002\b\u000301¢\u0006\u0004\bF\u0010GJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\u0005\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\nR\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R*\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00128\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017R\u001f\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\u00128\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b(\u0010\u0017R\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00128\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0015\u001a\u0004\b*\u0010\u0017R\u001d\u00100\u001a\u00020+8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001d\u00102\u001a\u0006\u0012\u0002\b\u0003018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R*\u00106\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010\u001d\u001a\u0004\b7\u0010\u001f\"\u0004\b8\u0010!R%\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0002090\u00128\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u0015\u001a\u0004\b;\u0010\u0017R.\u0010=\u001a\u0004\u0018\u00010<2\b\u0010\u001b\u001a\u0004\u0018\u00010<8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR*\u0010C\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010\u001d\u001a\u0004\bD\u0010\u001f\"\u0004\bE\u0010!¨\u0006I"}, d2 = {"Lcom/baidu/tieba/frs/videomiddlepagelight/VideoMiddlePageViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/baidu/tieba/card/data/BaseCardInfo;", "data", "", "addData", "(Lcom/baidu/tieba/card/data/BaseCardInfo;)V", "", "(Ljava/util/List;)V", "loadData", "()V", "playLastVideo", "playNextVideo", "", "position", "playVideoAtPosition", "(I)V", "resumePlayVideo", "Landroidx/lifecycle/MutableLiveData;", "Landroid/content/res/Configuration;", "configuration", "Landroidx/lifecycle/MutableLiveData;", "getConfiguration", "()Landroidx/lifecycle/MutableLiveData;", "curPlayingVideoPos", "getCurPlayingVideoPos", "", "value", "from", "Ljava/lang/String;", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "fromTid", "getFromTid", "setFromTid", "", "hasMore", "getHasMore", "isLoading", "loadErrorMsg", "getLoadErrorMsg", "Lcom/baidu/tieba/frs/videomiddlepage/VideoMiddleModel;", "model$delegate", "Lkotlin/Lazy;", "getModel", "()Lcom/baidu/tieba/frs/videomiddlepage/VideoMiddleModel;", "model", "Lcom/baidu/tbadk/TbPageContext;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "getPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "stType", "getStType", "setStType", "", "videoDataList", "getVideoDataList", "Lcom/baidu/tieba/play/monitor/VideoSerializeVideoThreadInfo;", "videoThreadInfo", "Lcom/baidu/tieba/play/monitor/VideoSerializeVideoThreadInfo;", "getVideoThreadInfo", "()Lcom/baidu/tieba/play/monitor/VideoSerializeVideoThreadInfo;", "setVideoThreadInfo", "(Lcom/baidu/tieba/play/monitor/VideoSerializeVideoThreadInfo;)V", "yuelaouLocate", "getYuelaouLocate", "setYuelaouLocate", "<init>", "(Lcom/baidu/tbadk/TbPageContext;)V", "Companion", "frsExtra_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class VideoMiddlePageViewModel extends ViewModel {
    public static final /* synthetic */ KProperty[] k = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(VideoMiddlePageViewModel.class), "model", "getModel()Lcom/baidu/tieba/frs/videomiddlepage/VideoMiddleModel;"))};

    /* renamed from: a  reason: collision with root package name */
    public final MutableLiveData<List<BaseCardInfo>> f16376a = new MutableLiveData<>();

    /* renamed from: b  reason: collision with root package name */
    public final MutableLiveData<Boolean> f16377b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    public final MutableLiveData<Boolean> f16378c = new MutableLiveData<>();

    /* renamed from: d  reason: collision with root package name */
    public final MutableLiveData<String> f16379d = new MutableLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    public final MutableLiveData<Integer> f16380e = new MutableLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    public final MutableLiveData<Configuration> f16381f = new MutableLiveData<>();

    /* renamed from: g  reason: collision with root package name */
    public final Lazy f16382g = LazyKt__LazyJVMKt.lazy(new VideoMiddlePageViewModel$model$2(this));

    /* renamed from: h  reason: collision with root package name */
    public String f16383h = "";
    public String i = "";
    public final TbPageContext<?> j;

    public VideoMiddlePageViewModel(TbPageContext<?> tbPageContext) {
        this.j = tbPageContext;
        this.f16377b.setValue(Boolean.FALSE);
        this.f16378c.setValue(Boolean.FALSE);
        this.f16376a.setValue(new ArrayList());
        this.f16380e.setValue(0);
    }

    public final void a(List<? extends BaseCardInfo> list) {
        List<BaseCardInfo> value = this.f16376a.getValue();
        if (value != null) {
            value.addAll(list);
        }
        MutableLiveData<List<BaseCardInfo>> mutableLiveData = this.f16376a;
        mutableLiveData.setValue(mutableLiveData.getValue());
    }

    public final MutableLiveData<Configuration> b() {
        return this.f16381f;
    }

    public final MutableLiveData<Integer> c() {
        return this.f16380e;
    }

    public final String d() {
        return this.i;
    }

    public final String e() {
        return this.f16383h;
    }

    public final MutableLiveData<Boolean> f() {
        return this.f16378c;
    }

    public final MutableLiveData<String> g() {
        return this.f16379d;
    }

    public final VideoMiddleModel h() {
        Lazy lazy = this.f16382g;
        KProperty kProperty = k[0];
        return (VideoMiddleModel) lazy.getValue();
    }

    public final TbPageContext<?> i() {
        return this.j;
    }

    public final MutableLiveData<List<BaseCardInfo>> j() {
        return this.f16376a;
    }

    public final MutableLiveData<Boolean> k() {
        return this.f16377b;
    }

    public final void l() {
        if (Intrinsics.areEqual(this.f16377b.getValue(), Boolean.FALSE)) {
            this.f16377b.setValue(Boolean.TRUE);
            h().setFrom(this.i);
            h().LoadData();
        }
    }

    public final void m() {
        List<BaseCardInfo> value = this.f16376a.getValue();
        Integer valueOf = value != null ? Integer.valueOf(value.size()) : null;
        Integer value2 = this.f16380e.getValue();
        if (valueOf == null || valueOf.intValue() <= 0 || value2 == null || value2.intValue() <= 0) {
            return;
        }
        MutableLiveData<Integer> mutableLiveData = this.f16380e;
        Integer value3 = mutableLiveData.getValue();
        mutableLiveData.setValue(value3 != null ? Integer.valueOf(value3.intValue() - 1) : null);
    }

    public final void n() {
        List<BaseCardInfo> value = this.f16376a.getValue();
        Integer valueOf = value != null ? Integer.valueOf(value.size()) : null;
        Integer value2 = this.f16380e.getValue();
        if (valueOf == null || valueOf.intValue() <= 0 || value2 == null || value2.intValue() >= valueOf.intValue() - 1) {
            return;
        }
        MutableLiveData<Integer> mutableLiveData = this.f16380e;
        Integer value3 = mutableLiveData.getValue();
        mutableLiveData.setValue(value3 != null ? Integer.valueOf(value3.intValue() + 1) : null);
        if ((valueOf.intValue() - 1) - value2.intValue() <= 3) {
            l();
        }
    }

    public final void o(int i) {
        List<BaseCardInfo> value = this.f16376a.getValue();
        Integer valueOf = value != null ? Integer.valueOf(value.size()) : null;
        Integer value2 = this.f16380e.getValue();
        if (valueOf == null || valueOf.intValue() <= 0 || Intrinsics.compare(i, valueOf.intValue()) >= 0) {
            return;
        }
        this.f16380e.setValue(Integer.valueOf(i));
        if (value2 == null || (valueOf.intValue() - 1) - value2.intValue() > 3) {
            return;
        }
        l();
    }

    public final void p() {
        Integer value = this.f16380e.getValue();
        if (value == null) {
            value = 0;
        }
        o(value.intValue());
    }

    public final void q(String str) {
        this.i = str;
        h().setFrom(str);
    }

    public final void r(String str) {
        this.f16383h = str;
        h().x(str);
    }

    public final void s(String str) {
        h().z(str);
    }

    public final void t(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        h().A(videoSerializeVideoThreadInfo);
    }

    public final void u(String str) {
        h().y(str);
    }
}
