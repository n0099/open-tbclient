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
import kotlin.d;
import kotlin.e;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.s;
import kotlin.reflect.j;
@e
/* loaded from: classes2.dex */
public final class VideoMiddlePageViewModel extends ViewModel {
    static final /* synthetic */ j[] $$delegatedProperties = {s.a(new PropertyReference1Impl(s.G(VideoMiddlePageViewModel.class), "model", "getModel()Lcom/baidu/tieba/frs/videomiddlepage/VideoMiddleModel;"))};
    public static final a jQX = new a(null);
    private String from;
    private String iyl;
    private VideoSerializeVideoThreadInfo jPu;
    private final MutableLiveData<List<BaseCardInfo>> jQP;
    private final MutableLiveData<Boolean> jQQ;
    private final MutableLiveData<Boolean> jQR;
    private final MutableLiveData<String> jQS;
    private final MutableLiveData<Integer> jQT;
    private final MutableLiveData<Configuration> jQU;
    private final kotlin.c jQV;
    private String jQW;
    private final TbPageContext<?> pageContext;
    private String stType;

    public final VideoMiddleModel cNd() {
        kotlin.c cVar = this.jQV;
        j jVar = $$delegatedProperties[0];
        return (VideoMiddleModel) cVar.getValue();
    }

    @e
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    public VideoMiddlePageViewModel(TbPageContext<?> tbPageContext) {
        p.p(tbPageContext, "pageContext");
        this.pageContext = tbPageContext;
        this.jQP = new MutableLiveData<>();
        this.jQQ = new MutableLiveData<>();
        this.jQR = new MutableLiveData<>();
        this.jQS = new MutableLiveData<>();
        this.jQT = new MutableLiveData<>();
        this.jQU = new MutableLiveData<>();
        this.jQV = d.b(new VideoMiddlePageViewModel$model$2(this));
        this.jQW = "";
        this.iyl = "";
        this.stType = "";
        this.from = "";
        this.jQQ.setValue(false);
        this.jQR.setValue(false);
        this.jQP.setValue(new ArrayList());
        this.jQT.setValue(0);
    }

    public final TbPageContext<?> getPageContext() {
        return this.pageContext;
    }

    public final MutableLiveData<List<BaseCardInfo>> cMX() {
        return this.jQP;
    }

    public final MutableLiveData<Boolean> cMY() {
        return this.jQQ;
    }

    public final MutableLiveData<Boolean> cMZ() {
        return this.jQR;
    }

    public final MutableLiveData<String> cNa() {
        return this.jQS;
    }

    public final MutableLiveData<Integer> cNb() {
        return this.jQT;
    }

    public final MutableLiveData<Configuration> cNc() {
        return this.jQU;
    }

    public final String cNe() {
        return this.jQW;
    }

    public final void Lx(String str) {
        p.p(str, "value");
        this.jQW = str;
        cNd().setId(str);
    }

    public final void setYuelaouLocate(String str) {
        p.p(str, "value");
        this.iyl = str;
        cNd().setLocation(str);
    }

    public final void setStType(String str) {
        p.p(str, "value");
        this.stType = str;
        cNd().Ky(str);
    }

    public final void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.jPu = videoSerializeVideoThreadInfo;
        cNd().a(videoSerializeVideoThreadInfo);
    }

    public final String getFrom() {
        return this.from;
    }

    public final void setFrom(String str) {
        p.p(str, "value");
        this.from = str;
        cNd().setFrom(str);
    }

    public final void loadData() {
        if (p.l(this.jQQ.getValue(), false)) {
            this.jQQ.setValue(true);
            cNd().setFrom(this.from);
            cNd().LoadData();
        }
    }

    public final void cv(List<? extends BaseCardInfo> list) {
        p.p(list, "data");
        List<BaseCardInfo> value = this.jQP.getValue();
        if (value != null) {
            value.addAll(list);
        }
        this.jQP.setValue(this.jQP.getValue());
    }

    public final void cNf() {
        List<BaseCardInfo> value = this.jQP.getValue();
        Integer valueOf = value != null ? Integer.valueOf(value.size()) : null;
        Integer value2 = this.jQT.getValue();
        if (valueOf != null && valueOf.intValue() > 0 && value2 != null && value2.intValue() < valueOf.intValue() - 1) {
            MutableLiveData<Integer> mutableLiveData = this.jQT;
            Integer value3 = this.jQT.getValue();
            mutableLiveData.setValue(value3 != null ? Integer.valueOf(value3.intValue() + 1) : null);
            if ((valueOf.intValue() - 1) - value2.intValue() <= 3) {
                loadData();
            }
        }
    }

    public final void cNg() {
        List<BaseCardInfo> value = this.jQP.getValue();
        Integer valueOf = value != null ? Integer.valueOf(value.size()) : null;
        Integer value2 = this.jQT.getValue();
        if (valueOf != null && valueOf.intValue() > 0 && value2 != null && value2.intValue() > 0) {
            MutableLiveData<Integer> mutableLiveData = this.jQT;
            Integer value3 = this.jQT.getValue();
            mutableLiveData.setValue(value3 != null ? Integer.valueOf(value3.intValue() - 1) : null);
        }
    }

    public final void cNh() {
        Integer value = this.jQT.getValue();
        if (value == null) {
            value = 0;
        }
        Ba(value.intValue());
    }

    public final void Ba(int i) {
        List<BaseCardInfo> value = this.jQP.getValue();
        Integer valueOf = value != null ? Integer.valueOf(value.size()) : null;
        Integer value2 = this.jQT.getValue();
        if (valueOf != null && valueOf.intValue() > 0 && p.compare(i, valueOf.intValue()) < 0) {
            this.jQT.setValue(Integer.valueOf(i));
            if (value2 != null && (valueOf.intValue() - 1) - value2.intValue() <= 3) {
                loadData();
            }
        }
    }
}
