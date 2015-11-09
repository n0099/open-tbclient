package com.baidu.tbadk.editortools.c;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.a;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.editortools.f {
    private BaseActivity<?> aqA;
    private c aqG;
    private a.d aqM;
    private String aqW;
    private a<?> aqX;
    private boolean aqY;
    private a.d aqZ;
    private String aqq;
    private VoiceData.VoiceModel aqr;
    private com.baidu.tieba.tbadkCore.writeModel.a aqv;
    private AntiData aqy;
    private String mPostId;

    public p(com.baidu.tbadk.editortools.j jVar) {
        super(jVar);
        this.aqq = "";
        this.aqW = null;
        this.aqY = false;
        this.aqM = new q(this);
    }

    public void b(BaseActivity<?> baseActivity) {
        this.aqA = baseActivity;
    }

    public BaseActivity<?> Bj() {
        return this.aqA;
    }

    public String Bx() {
        return this.aqq;
    }

    public void fb(String str) {
        this.aqq = str;
    }

    public void b(a<?> aVar) {
        this.aqX = aVar;
        if (aVar != null) {
            this.mPostId = aVar.AV();
        }
    }

    public void c(BaseActivity<?> baseActivity) {
        this.aqv = new com.baidu.tieba.tbadkCore.writeModel.a(baseActivity);
        this.aqv.b(this.aqM);
        ad.b(this.aqX.AV(), new r(this));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    ArrayList<String> T = com.baidu.tieba.tbadkCore.util.l.T(intent);
                    if (T != null) {
                        q(T);
                        return;
                    }
                    return;
                case 12006:
                    if (Az() != null) {
                        Az().hide();
                    }
                    BA();
                    bj(true);
                    WriteData ayT = this.aqv.ayT();
                    this.aqv.c((WriteData) null);
                    this.aqv.gC(false);
                    if (ayT != null && ayT != null && ayT.getType() == 2) {
                        this.aqX.AU();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void By() {
        if (this.aqv.ayT() == null) {
            this.aqv.c(this.aqX.eW(this.aqX.AV()));
        }
        if (this.aqv.ayT() != null) {
            if (this.aqG != null) {
                this.aqG.AX();
            }
            if (this.aqG != null) {
                this.aqG.AX();
            }
            if (this.aqy != null) {
                if ((!AntiHelper.e(this.aqy) && !AntiHelper.f(this.aqy) && !AntiHelper.g(this.aqy)) || !AntiHelper.a(Bj().getActivity(), this.aqy, AntiHelper.OperationType.REPLY, PageType.FLOOR_IN_FLOOR)) {
                    if (this.aqy != null && this.aqy.getIfpost() == 0 && !TextUtils.isEmpty(this.aqy.getForbid_info())) {
                        com.baidu.adp.lib.util.k.showToast(this.aqA.getPageContext().getPageActivity(), this.aqy.getForbid_info());
                        return;
                    }
                } else {
                    return;
                }
            }
            if (this.aqG != null) {
                this.aqG.AX();
            }
            this.aqv.ayT().setContent(this.aqq);
            if (this.mPostId != null) {
                this.aqv.ayT().setRepostId(this.aqX.AV());
            }
            if (this.aqr != null) {
                if (this.aqr.getId() != null) {
                    this.aqv.ayT().setVoice(this.aqr.getId());
                    this.aqv.ayT().setVoiceDuringTime(this.aqr.duration);
                } else {
                    this.aqv.ayT().setVoice(null);
                    this.aqv.ayT().setVoiceDuringTime(-1);
                }
            } else {
                this.aqv.ayT().setVoice(null);
                this.aqv.ayT().setVoiceDuringTime(-1);
            }
            if (!this.aqv.ayX()) {
                Bj().showToast(i.h.write_img_limit);
                return;
            }
            if (this.aqG != null) {
                this.aqG.AX();
            }
            if (!this.aqv.ayU()) {
            }
        }
    }

    public void onDestory() {
        Bz();
        this.aqv.cancelLoadData();
    }

    public void onStop() {
    }

    public void Bz() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aqq);
        writeData.setThreadId(this.mPostId);
        ad.d(this.mPostId, writeData);
    }

    public void BA() {
        ad.c(this.mPostId, (WriteData) null);
    }

    public void s(int i, String str) {
        if (AntiHelper.lr(i)) {
            AntiHelper.Q(Bj().getActivity(), str);
        } else if (i == 230277 || i == 230278) {
            ff(str);
        } else {
            Bj().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.aqy = antiData;
    }

    private void ff(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Bj().getActivity());
        aVar.cu(str);
        aVar.b(i.h.know, new s(this));
        aVar.b(Bj().getPageContext()).sR();
    }

    private void q(ArrayList<String> arrayList) {
        if (Az() != null) {
            Az().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aqr = voiceModel;
    }

    public boolean BB() {
        return this.aqY;
    }

    public void bk(boolean z) {
        this.aqY = z;
    }

    public void fg(String str) {
        bk(true);
        Az().ox();
        if (str != null && str.length() != 0) {
            fi(Bj().getResources().getString(i.h.reply_sub_floor).replace("%s", str));
        } else {
            fi("");
        }
        TiebaStatic.eventStat(Bj().getActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fh(String str) {
        bk(true);
        fi(str);
        TiebaStatic.eventStat(Bj().getActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void BC() {
        bk(false);
        Az().hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(String str) {
        if (Az() != null) {
            Az().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fj(String str) {
        String string = TbadkCoreApplication.m411getInst().getResources().getString(i.h.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (as.isEmpty(this.aqq) || this.aqq.matches(str2)) {
            if (this.aqW != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aqW).lookingAt()) {
                    fh(this.aqW);
                    return;
                } else {
                    fg(str);
                    return;
                }
            }
            fg(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aqq);
        this.aqW = this.aqq;
        if (matcher.lookingAt()) {
            fh(this.aqq);
        } else {
            fg(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(boolean z) {
        if (Az() != null) {
            Az().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(a.d dVar) {
        this.aqZ = dVar;
    }

    public void a(c cVar) {
        this.aqG = cVar;
    }
}
