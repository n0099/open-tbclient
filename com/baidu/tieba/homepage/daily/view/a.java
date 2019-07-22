package com.baidu.tieba.homepage.daily.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadForumUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.view.k;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.a<bg> {
    private boolean Yd;
    public PlayVoiceBntNew Ym;
    private View cUw;
    private final View.OnClickListener caw;
    private bg ccj;
    private final View.OnClickListener cdu;
    private ThreadCommentAndPraiseInfoLayout dEB;
    private ConstrainImageGroup eCM;
    private View.OnClickListener eCR;
    private final View.OnClickListener eCS;
    private View gdh;
    private ThreadForumUserInfoLayout gei;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.Yd = true;
        this.mStType = null;
        this.eCR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZo() != null) {
                    a.this.aZo().a(view, a.this.ccj);
                }
                a.this.aqb();
            }
        };
        this.eCS = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bg> aZo = a.this.aZo();
                if (aZo != null) {
                    view.setTag("2");
                    aZo.a(view, a.this.ccj);
                }
            }
        };
        this.caw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZo() != null) {
                    a.this.aZo().a(view, a.this.ccj);
                }
            }
        };
        this.cdu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZo() != null) {
                    a.this.aZo().a(view, a.this.ccj);
                }
            }
        };
        View view = getView();
        this.gei = (ThreadForumUserInfoLayout) view.findViewById(R.id.forum_user_info_layout);
        this.gei.setForumAfterClickListener(this.caw);
        this.gei.setLikeButtonAfterClickListener(this.cdu);
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.Ym = (PlayVoiceBntNew) view.findViewById(R.id.voice_button);
        this.Ym.setAfterClickListener(this.eCS);
        this.eCM = (ConstrainImageGroup) view.findViewById(R.id.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.eCM.setChildClickListener(this.eCR);
        this.eCM.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.h(1.0d);
        fVar.fR(false);
        this.eCM.setImageProcessor(fVar);
        this.gdh = view.findViewById(R.id.no_image_divider_line);
        this.dEB = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_info_layout);
        this.dEB.setOnClickListener(this.eCR);
        this.dEB.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aZo() != null) {
                    a.this.aZo().a(view2, a.this.ccj);
                }
                if (a.this.ccj != null) {
                    n.vw(a.this.ccj.getId());
                    a.this.buZ();
                }
            }
        });
        this.dEB.setShowCommonView();
        this.cUw = view.findViewById(R.id.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.eCM != null) {
            this.eCM.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eCM != null) {
            this.eCM.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eCM != null) {
            this.eCM.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.gei != null) {
            this.gei.setPageUniqueId(bdUniqueId);
        }
        if (this.eCM != null) {
            this.eCM.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.k(getView(), R.drawable.addresslist_item_bg);
            this.gei.onChangeSkinType(i);
            this.eCM.onChangeSkinType();
            this.dEB.onChangeSkinType();
            am.l(this.cUw, R.color.cp_bg_line_e);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_daily_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bg bgVar) {
        if (bgVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.ccj = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eCR);
        }
        this.gei.setData(this.ccj);
        ag(this.ccj);
        ArrayList<VoiceData.VoiceModel> aeL = this.ccj.aeL();
        if (v.aa(aeL)) {
            this.Ym.setVisibility(8);
            iC(false);
        } else {
            this.Ym.setVisibility(0);
            iC(true);
            VoiceData.VoiceModel voiceModel = aeL.get(0);
            this.Ym.setVoiceModel(voiceModel);
            this.Ym.setTag(voiceModel);
            this.Ym.bIl();
            if (voiceModel != null) {
                this.Ym.vY(voiceModel.voice_status.intValue());
            }
            this.Ym.cqz();
        }
        ArrayList<MediaData> aeH = this.ccj.aeH();
        if (i.aca().ace() && v.Z(aeH) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aeH.size(); i++) {
                MediaData mediaData = (MediaData) v.c(aeH, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.Z(linkedList) > 0) {
                this.eCM.setVisibility(0);
                this.gdh.setVisibility(8);
                this.eCM.setFromCDN(this.Yd);
                this.eCM.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        ab<bg> aZo = a.this.aZo();
                        if (aZo != null) {
                            view.setTag("1");
                            aZo.a(view, a.this.ccj);
                        }
                        a.this.aqb();
                    }
                });
                this.eCM.setImageMediaList(linkedList);
            } else {
                this.eCM.setVisibility(8);
                this.gdh.setVisibility(0);
            }
        } else {
            this.eCM.setVisibility(8);
            this.gdh.setVisibility(0);
        }
        this.dEB.cbF = this.currentPageType;
        this.dEB.setData(this.ccj);
        bpo();
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean ag(bg bgVar) {
        SpannableStringBuilder o = bgVar.o(false, true);
        if (o == null || StringUtils.isNull(o.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(o));
            this.mTitle.setText(o);
            n.a(this.mTitle, bgVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buZ() {
        if (n.vx(this.ccj.getId())) {
            n.a(this.mTitle, this.ccj.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private void bpo() {
        if (this.mTitle != null && this.Ym != null && this.eCM != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Ym.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.Ym.setLayoutParams(layoutParams);
            if (this.Ym.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eCM.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.eCM.setLayoutParams(layoutParams2);
            }
        }
    }

    private void iC(boolean z) {
        if (this.eCM != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eCM.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.eCM.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqb() {
        if (this.ccj != null) {
            n.vw(this.ccj.getId());
            n.a(this.mTitle, this.ccj.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.ccj, null, this.mStType, 18005, true, false, false);
            if (this.ccj.agk() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.ccj.getFid()));
                createFromThreadCfg.setForumName(this.ccj.aeC());
            } else {
                createFromThreadCfg.setForumId(this.ccj.agk().getForumId());
                createFromThreadCfg.setForumName(this.ccj.agk().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public int bvm() {
        if (this.gei == null || this.gei.getHeaderImg() == null) {
            return -1;
        }
        return this.gei.getHeaderImg().getId();
    }

    public int bvn() {
        if (this.gei == null || this.gei.getForumName() == null) {
            return -1;
        }
        return this.gei.getForumName().getId();
    }

    public int bvo() {
        if (this.gei == null || this.gei.getForumName() == null) {
            return -1;
        }
        return this.gei.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dEB != null) {
            this.dEB.setShareReportFrom(i);
        }
    }

    public void tF(int i) {
        if (this.dEB != null) {
            this.dEB.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dEB != null) {
            this.dEB.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
