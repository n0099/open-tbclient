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
    public static final a jPo = new a(null);
    private String from;
    private String iwC;
    private VideoSerializeVideoThreadInfo jNL;
    private final MutableLiveData<List<BaseCardInfo>> jPg;
    private final MutableLiveData<Boolean> jPh;
    private final MutableLiveData<Boolean> jPi;
    private final MutableLiveData<String> jPj;
    private final MutableLiveData<Integer> jPk;
    private final MutableLiveData<Configuration> jPl;
    private final kotlin.c jPm;
    private String jPn;
    private final TbPageContext<?> pageContext;
    private String stType;

    public final VideoMiddleModel cMX() {
        kotlin.c cVar = this.jPm;
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
        this.jPg = new MutableLiveData<>();
        this.jPh = new MutableLiveData<>();
        this.jPi = new MutableLiveData<>();
        this.jPj = new MutableLiveData<>();
        this.jPk = new MutableLiveData<>();
        this.jPl = new MutableLiveData<>();
        this.jPm = d.b(new VideoMiddlePageViewModel$model$2(this));
        this.jPn = "";
        this.iwC = "";
        this.stType = "";
        this.from = "";
        this.jPh.setValue(false);
        this.jPi.setValue(false);
        this.jPg.setValue(new ArrayList());
        this.jPk.setValue(0);
    }

    public final TbPageContext<?> getPageContext() {
        return this.pageContext;
    }

    public final MutableLiveData<List<BaseCardInfo>> cMR() {
        return this.jPg;
    }

    public final MutableLiveData<Boolean> cMS() {
        return this.jPh;
    }

    public final MutableLiveData<Boolean> cMT() {
        return this.jPi;
    }

    public final MutableLiveData<String> cMU() {
        return this.jPj;
    }

    public final MutableLiveData<Integer> cMV() {
        return this.jPk;
    }

    public final MutableLiveData<Configuration> cMW() {
        return this.jPl;
    }

    public final String cMY() {
        return this.jPn;
    }

    public final void Lo(String str) {
        p.o(str, "value");
        this.jPn = str;
        cMX().setId(str);
    }

    public final void setYuelaouLocate(String str) {
        p.o(str, "value");
        this.iwC = str;
        cMX().setLocation(str);
    }

    public final void setStType(String str) {
        p.o(str, "value");
        this.stType = str;
        cMX().Kp(str);
    }

    public final void a(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.jNL = videoSerializeVideoThreadInfo;
        cMX().a(videoSerializeVideoThreadInfo);
    }

    public final String getFrom() {
        return this.from;
    }

    public final void setFrom(String str) {
        p.o(str, "value");
        this.from = str;
        cMX().setFrom(str);
    }

    public final void loadData() {
        if (p.l(this.jPh.getValue(), false)) {
            this.jPh.setValue(true);
            cMX().setFrom(this.from);
            cMX().LoadData();
        }
    }

    public final void cv(List<? extends BaseCardInfo> list) {
        p.o(list, "data");
        List<BaseCardInfo> value = this.jPg.getValue();
        if (value != null) {
            value.addAll(list);
        }
        this.jPg.setValue(this.jPg.getValue());
    }

    public final void cMZ() {
        List<BaseCardInfo> value = this.jPg.getValue();
        Integer valueOf = value != null ? Integer.valueOf(value.size()) : null;
        Integer value2 = this.jPk.getValue();
        if (valueOf != null && valueOf.intValue() > 0 && value2 != null && value2.intValue() < valueOf.intValue() - 1) {
            MutableLiveData<Integer> mutableLiveData = this.jPk;
            Integer value3 = this.jPk.getValue();
            mutableLiveData.setValue(value3 != null ? Integer.valueOf(value3.intValue() + 1) : null);
            if ((valueOf.intValue() - 1) - value2.intValue() <= 3) {
                loadData();
            }
        }
    }

    public final void cNa() {
        List<BaseCardInfo> value = this.jPg.getValue();
        Integer valueOf = value != null ? Integer.valueOf(value.size()) : null;
        Integer value2 = this.jPk.getValue();
        if (valueOf != null && valueOf.intValue() > 0 && value2 != null && value2.intValue() > 0) {
            MutableLiveData<Integer> mutableLiveData = this.jPk;
            Integer value3 = this.jPk.getValue();
            mutableLiveData.setValue(value3 != null ? Integer.valueOf(value3.intValue() - 1) : null);
        }
    }

    public final void cNb() {
        Integer value = this.jPk.getValue();
        if (value == null) {
            value = 0;
        }
        AZ(value.intValue());
    }

    public final void AZ(int i) {
        List<BaseCardInfo> value = this.jPg.getValue();
        Integer valueOf = value != null ? Integer.valueOf(value.size()) : null;
        Integer value2 = this.jPk.getValue();
        if (valueOf != null && valueOf.intValue() > 0 && p.compare(i, valueOf.intValue()) < 0) {
            this.jPk.setValue(Integer.valueOf(i));
            if (value2 != null && (valueOf.intValue() - 1) - value2.intValue() <= 3) {
                loadData();
            }
        }
    }
}
