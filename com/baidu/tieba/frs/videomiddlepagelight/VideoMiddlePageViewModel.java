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
    public static final a jPa = new a(null);
    private String from;
    private String iwo;
    private VideoSerializeVideoThreadInfo jNx;
    private final MutableLiveData<List<BaseCardInfo>> jOS;
    private final MutableLiveData<Boolean> jOT;
    private final MutableLiveData<Boolean> jOU;
    private final MutableLiveData<String> jOV;
    private final MutableLiveData<Integer> jOW;
    private final MutableLiveData<Configuration> jOX;
    private final kotlin.c jOY;
    private String jOZ;
    private final TbPageContext<?> pageContext;
    private String stType;

    public final VideoMiddleModel cMQ() {
        kotlin.c cVar = this.jOY;
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
        p.o(tbPageContext, "pageContext");
        this.pageContext = tbPageContext;
        this.jOS = new MutableLiveData<>();
        this.jOT = new MutableLiveData<>();
        this.jOU = new MutableLiveData<>();
        this.jOV = new MutableLiveData<>();
        this.jOW = new MutableLiveData<>();
        this.jOX = new MutableLiveData<>();
        this.jOY = d.b(new VideoMiddlePageViewModel$model$2(this));
        this.jOZ = "";
        this.iwo = "";
        this.stType = "";
        this.from = "";
        this.jOT.setValue(false);
        this.jOU.setValue(false);
        this.jOS.setValue(new ArrayList());
        this.jOW.setValue(0);
    }

    public final TbPageContext<?> getPageContext() {
        return this.pageContext;
    }

    public final MutableLiveData<List<BaseCardInfo>> cMK() {
        return this.jOS;
    }

    public final MutableLiveData<Boolean> cML() {
        return this.jOT;
    }

    public final MutableLiveData<Boolean> cMM() {
        return this.jOU;
    }

    public final MutableLiveData<String> cMN() {
        return this.jOV;
    }

    public final MutableLiveData<Integer> cMO() {
        return this.jOW;
    }

    public final MutableLiveData<Configuration> cMP() {
        return this.jOX;
    }

    public final String cMR() {
        return this.jOZ;
    }

    public final void Ln(String str) {
        p.o(str, "value");
        this.jOZ = str;
        cMQ().setId(str);
    }

    public final void setYuelaouLocate(String str) {
        p.o(str, "value");
        this.iwo = str;
        cMQ().setLocation(str);
    }

    public final void setStType(String str) {
        p.o(str, "value");
        this.stType = str;
        cMQ().Ko(str);
    }

    public final void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.jNx = videoSerializeVideoThreadInfo;
        cMQ().a(videoSerializeVideoThreadInfo);
    }

    public final String getFrom() {
        return this.from;
    }

    public final void setFrom(String str) {
        p.o(str, "value");
        this.from = str;
        cMQ().setFrom(str);
    }

    public final void loadData() {
        if (p.l(this.jOT.getValue(), false)) {
            this.jOT.setValue(true);
            cMQ().setFrom(this.from);
            cMQ().LoadData();
        }
    }

    public final void cv(List<? extends BaseCardInfo> list) {
        p.o(list, "data");
        List<BaseCardInfo> value = this.jOS.getValue();
        if (value != null) {
            value.addAll(list);
        }
        this.jOS.setValue(this.jOS.getValue());
    }

    public final void cMS() {
        List<BaseCardInfo> value = this.jOS.getValue();
        Integer valueOf = value != null ? Integer.valueOf(value.size()) : null;
        Integer value2 = this.jOW.getValue();
        if (valueOf != null && valueOf.intValue() > 0 && value2 != null && value2.intValue() < valueOf.intValue() - 1) {
            MutableLiveData<Integer> mutableLiveData = this.jOW;
            Integer value3 = this.jOW.getValue();
            mutableLiveData.setValue(value3 != null ? Integer.valueOf(value3.intValue() + 1) : null);
            if ((valueOf.intValue() - 1) - value2.intValue() <= 3) {
                loadData();
            }
        }
    }

    public final void cMT() {
        List<BaseCardInfo> value = this.jOS.getValue();
        Integer valueOf = value != null ? Integer.valueOf(value.size()) : null;
        Integer value2 = this.jOW.getValue();
        if (valueOf != null && valueOf.intValue() > 0 && value2 != null && value2.intValue() > 0) {
            MutableLiveData<Integer> mutableLiveData = this.jOW;
            Integer value3 = this.jOW.getValue();
            mutableLiveData.setValue(value3 != null ? Integer.valueOf(value3.intValue() - 1) : null);
        }
    }

    public final void cMU() {
        Integer value = this.jOW.getValue();
        if (value == null) {
            value = 0;
        }
        AZ(value.intValue());
    }

    public final void AZ(int i) {
        List<BaseCardInfo> value = this.jOS.getValue();
        Integer valueOf = value != null ? Integer.valueOf(value.size()) : null;
        Integer value2 = this.jOW.getValue();
        if (valueOf != null && valueOf.intValue() > 0 && p.compare(i, valueOf.intValue()) < 0) {
            this.jOW.setValue(Integer.valueOf(i));
            if (value2 != null && (valueOf.intValue() - 1) - value2.intValue() <= 3) {
                loadData();
            }
        }
    }
}
