package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class af extends a<com.baidu.tieba.card.a.q> {
    private TbPageContext<?> Nw;
    private View aPo;
    private TextView aPr;
    public PlayVoiceBnt aPw;
    private TextView aPx;
    private FrsCommonImageLayout aPy;
    public ThreadCommentAndPraiseInfoLayout aPz;
    public ClickableHeaderImageView aQk;
    private final String aQl;
    private final String aQm;
    private com.baidu.tieba.card.a.q aQn;
    private UserIconLayout aQo;
    private View.OnClickListener aQp;
    private CustomMessageListener aQq;
    private FrsCommonImageLayout.b aQr;
    private final View.OnClickListener aQs;
    private final View.OnClickListener aQt;
    private boolean aeC;
    private final View.OnClickListener ahL;
    private final View.OnClickListener ahr;
    private int mSkinType;

    /* JADX DEBUG: Marked for inline */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to check method usage
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.MethodNode.getTopParentClass()" because "m" is null
    	at jadx.core.codegen.ClassGen.lambda$skipMethod$3(ClassGen.java:331)
    	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:178)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    	at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    	at jadx.core.codegen.ClassGen.skipMethod(ClassGen.java:332)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
     */
    public static /* synthetic */ com.baidu.tieba.card.a.q a(af afVar) {
        return afVar.aQn;
    }

    public af(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aQl = "1";
        this.aQm = "2";
        this.mSkinType = 3;
        this.aeC = true;
        this.aQp = new ag(this);
        this.aQq = new ah(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.aQr = new ai(this);
        this.aQs = new aj(this);
        this.aQt = new ak(this);
        this.ahL = new al(this);
        this.ahr = new am(this);
        View view = getView();
        this.Nw = tbPageContext;
        this.aPo = view.findViewById(t.g.card_home_page_normal_thread_top_line);
        this.aQk = (ClickableHeaderImageView) view.findViewById(t.g.card_home_page_normal_thread_user_header);
        this.aQk.setDefaultResource(17170445);
        this.aQk.setDefaultBgResource(t.f.icon_default_avatar_round);
        this.aQk.setRadius(com.baidu.adp.lib.util.k.c(this.Nw.getPageActivity(), t.e.ds70));
        this.aQo = (UserIconLayout) view.findViewById(t.g.card_home_page_normal_thread_user_layout);
        this.aPr = (TextView) view.findViewById(t.g.card_home_page_normal_thread_title);
        this.aPw = (PlayVoiceBnt) view.findViewById(t.g.card_home_page_normal_thread_abstract_voice);
        this.aPw.setAfterClickListener(this.aQt);
        this.aPx = (TextView) view.findViewById(t.g.card_home_page_normal_thread_abstract);
        this.aPy = (FrsCommonImageLayout) view.findViewById(t.g.card_home_page_normal_thread_img_layout);
        this.aPy.setDrawNum(false);
        this.aPy.setAfterChildClickListener(this.aQs);
        this.aPz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.card_home_page_normal_thread_info_layout);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.k(getView(), t.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.ar.l(this.aPo, t.d.cp_bg_line_c);
            this.aQo.xk();
            this.aPz.uv();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int JM() {
        return t.h.card_home_page_normal_thread;
    }

    public void a(com.baidu.tieba.card.a.q qVar) {
        int i;
        boolean z;
        int i2;
        int i3;
        if (qVar == null || qVar.aSc == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aQn = qVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.aQp);
        }
        d(this.Nw, TbadkCoreApplication.m411getInst().getSkinType());
        if (this.aQn.aSt) {
            this.aQk.setVisibility(8);
            this.aQo.setVisibility(8);
        } else {
            this.aQo.setVisibility(0);
            this.aQk.setVisibility(0);
            this.aQk.setData(qVar.aSc);
            this.aQk.setAfterClickListener(this.ahL);
        }
        this.aQo.setData(qVar.aSc);
        this.aQo.setUserAfterClickListener(this.ahL);
        this.aPz.setData(qVar.aSc);
        this.aPz.setForumAfterClickListener(this.ahr);
        this.aPz.setStType(ae.JV());
        this.aPz.setYuelaouLocate("feed#" + qVar.Ke());
        if (StringUtils.isNull(qVar.aSc.getTitle()) || qVar.aSc.tx() == 1) {
            this.aPr.setVisibility(8);
        } else {
            this.aPr.setVisibility(0);
            qVar.aSc.WK = 0;
            if (this.aQn.aSt) {
                this.aPr.setText(qVar.aSc.getTitle());
            } else {
                qVar.aSc.parser_title();
                this.aPr.setText(qVar.aSc.getSpan_str());
            }
            if (!JY()) {
                ae.a(this.aPr, qVar.Ki().getId(), t.d.cp_cont_b, t.d.cp_cont_d);
            } else {
                com.baidu.tbadk.core.util.ar.j((View) this.aPr, t.d.cp_cont_b);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (qVar.aSc.tr() != null && !StringUtils.isNull(qVar.aSc.tr())) {
            stringBuffer.append(qVar.aSc.tr());
        }
        ArrayList<MediaData> medias = qVar.aSc.getMedias();
        if (medias != null) {
            i = medias.size();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i4 = 0; i4 < i; i4++) {
                if (medias.get(i4).getVideoUrl() != null && medias.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(medias.get(i4).getVideoUrl());
                }
            }
            stringBuffer.append(stringBuffer2.toString());
            if (stringBuffer.length() > 0) {
                this.aPx.setText(stringBuffer.toString());
                this.aPx.setVisibility(0);
                if (!JY()) {
                    ae.a(this.aPx, qVar.aSc.getId(), t.d.cp_cont_j, t.d.cp_cont_d);
                } else {
                    com.baidu.tbadk.core.util.ar.j((View) this.aPx, t.d.cp_cont_j);
                }
            } else {
                this.aPx.setVisibility(8);
            }
        } else {
            this.aPx.setVisibility(8);
            i = 0;
        }
        ArrayList<VoiceData.VoiceModel> tw = qVar.aSc.tw();
        if (tw != null && tw.size() > 0) {
            this.aPw.setVisibility(0);
            VoiceData.VoiceModel voiceModel = tw.get(0);
            this.aPw.setVoiceModel(voiceModel);
            this.aPw.setTag(voiceModel);
            this.aPw.aNB();
            if (voiceModel != null) {
                this.aPw.jB(voiceModel.voice_status.intValue());
            }
            z = true;
        } else {
            this.aPw.setVisibility(8);
            z = false;
        }
        if (this.aQn.aSt && z) {
            this.aPy.setVisibility(8);
        } else if (com.baidu.tbadk.core.l.rn().rt() && com.baidu.tbadk.core.util.x.o(medias) != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < i) {
                if (medias.get(i5) == null || !(medias.get(i5).getType() == 3 || medias.get(i5).getType() == 5)) {
                    i3 = i6;
                } else {
                    i7++;
                    i3 = i6 + 1;
                }
                i5++;
                i7 = i7;
                i6 = i3;
            }
            if (i7 > 0) {
                MediaData[] mediaDataArr = new MediaData[i7];
                int i8 = 0;
                int i9 = 0;
                while (i9 < i && i8 < i7) {
                    if (medias.get(i9).getType() == 3 || medias.get(i9).getType() == 5) {
                        mediaDataArr[i8] = medias.get(i9);
                        i2 = i8 + 1;
                    } else {
                        i2 = i8;
                    }
                    i9++;
                    i8 = i2;
                }
                this.aPy.setVisibility(0);
                this.aPy.a(qVar.aSc, qVar.aSc.tn(), new StringBuilder(String.valueOf(qVar.aSc.getFid())).toString(), qVar.aSc.getTid());
                this.aPy.setShowBig(com.baidu.tbadk.core.util.ax.wg().wi());
                this.aPy.a(this.Nw, mediaDataArr, i6);
                this.aPy.setFromCDN(this.aeC);
                this.aPy.setImageFrom("other");
            } else {
                this.aPy.setVisibility(8);
            }
        } else {
            this.aPy.setVisibility(8);
        }
        JW();
    }

    private void JW() {
        if (!this.aQn.aut) {
            this.aPy.setOnChildClickListener(this.aQr);
            this.aPw.setClickable(false);
            this.aPz.setBarNameClickEnabled(false);
        } else {
            this.aPy.setOnChildClickListener(null);
            this.aPw.setClickable(true);
            this.aPz.setBarNameClickEnabled(true);
        }
        int childCount = this.aPy.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.aPy.getChildAt(i);
            if (childAt != null) {
                if (!this.aQn.aut) {
                    childAt.setClickable(false);
                } else {
                    childAt.setClickable(true);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.aeC = z;
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aPz != null && this.aQq != null) {
            this.aPz.h(bdUniqueId);
            this.aQq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aQq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JX() {
        if (this.aQn != null && this.aQn.aSc != null) {
            if (!JY()) {
                ae.gO(this.aQn.aSc.getId());
            }
            this.Nw.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Nw.getPageActivity()).createFromThreadCfg(this.aQn.aSc, this.aQn.aSc.tn(), ae.JV(), 18003, true, false, false).addLocateParam(this.aQn.Kf()).addFrom(getClass().getName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JY() {
        return this.aQn.aSt && !this.aQn.aut;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
