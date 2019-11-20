package com.baidu.tieba.homepage.daily.view;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bh;
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
public class a extends com.baidu.tieba.card.a<bh> {
    public PlayVoiceBntNew HH;
    private boolean Hx;
    private final View.OnClickListener coV;
    private bh cqG;
    private final View.OnClickListener crR;
    private ThreadCommentAndPraiseInfoLayout dSA;
    private View ddZ;
    private ConstrainImageGroup eMr;
    private View.OnClickListener eMw;
    private final View.OnClickListener eMx;
    private View gev;
    private ThreadForumUserInfoLayout gfw;
    private String mStType;
    private TextView mTitle;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.Hx = true;
        this.mStType = null;
        this.eMw = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZV() != null) {
                    a.this.aZV().a(view, a.this.cqG);
                }
                a.this.ash();
            }
        };
        this.eMx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<bh> aZV = a.this.aZV();
                if (aZV != null) {
                    view.setTag("2");
                    aZV.a(view, a.this.cqG);
                }
            }
        };
        this.coV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZV() != null) {
                    a.this.aZV().a(view, a.this.cqG);
                }
            }
        };
        this.crR = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aZV() != null) {
                    a.this.aZV().a(view, a.this.cqG);
                }
            }
        };
        View view = getView();
        this.gfw = (ThreadForumUserInfoLayout) view.findViewById(R.id.forum_user_info_layout);
        this.gfw.setForumAfterClickListener(this.coV);
        this.gfw.setLikeButtonAfterClickListener(this.crR);
        this.mTitle = (TextView) view.findViewById(R.id.thread_title);
        this.HH = (PlayVoiceBntNew) view.findViewById(R.id.voice_button);
        this.HH.setAfterClickListener(this.eMx);
        this.eMr = (ConstrainImageGroup) view.findViewById(R.id.thread_img_layout);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
        this.eMr.setChildClickListener(this.eMw);
        this.eMr.setImageMargin(dimensionPixelSize);
        f fVar = new f(3);
        fVar.g(1.0d);
        fVar.fJ(false);
        this.eMr.setImageProcessor(fVar);
        this.gev = view.findViewById(R.id.no_image_divider_line);
        this.dSA = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.thread_comment_info_layout);
        this.dSA.setOnClickListener(this.eMw);
        this.dSA.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.aZV() != null) {
                    a.this.aZV().a(view2, a.this.cqG);
                }
                if (a.this.cqG != null) {
                    n.uz(a.this.cqG.getId());
                    a.this.btd();
                }
            }
        });
        this.dSA.setShowCommonView();
        this.ddZ = view.findViewById(R.id.divider_line);
    }

    public void setSingleImageRatio(double d) {
        if (this.eMr != null) {
            this.eMr.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eMr != null) {
            this.eMr.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eMr != null) {
            this.eMr.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        if (this.gfw != null) {
            this.gfw.setPageUniqueId(bdUniqueId);
        }
        if (this.eMr != null) {
            this.eMr.setPageUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setBackgroundResource(getView(), R.drawable.addresslist_item_bg);
            this.gfw.onChangeSkinType(i);
            this.eMr.onChangeSkinType();
            this.dSA.onChangeSkinType();
            am.setBackgroundColor(this.ddZ, R.color.cp_bg_line_c);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_daily_normal_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(bh bhVar) {
        if (bhVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cqG = bhVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.eMw);
        }
        this.gfw.setData(this.cqG);
        ag(this.cqG);
        ArrayList<VoiceData.VoiceModel> aiS = this.cqG.aiS();
        if (v.isEmpty(aiS)) {
            this.HH.setVisibility(8);
            iI(false);
        } else {
            this.HH.setVisibility(0);
            iI(true);
            VoiceData.VoiceModel voiceModel = aiS.get(0);
            this.HH.setVoiceModel(voiceModel);
            this.HH.setTag(voiceModel);
            this.HH.bno();
            if (voiceModel != null) {
                this.HH.uJ(voiceModel.voice_status.intValue());
            }
            this.HH.cpA();
        }
        ArrayList<MediaData> aiO = this.cqG.aiO();
        if (i.ago().isShowImages() && v.getCount(aiO) != 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aiO.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aiO, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.eMr.setVisibility(0);
                this.gev.setVisibility(8);
                this.eMr.setFromCDN(this.Hx);
                this.eMr.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.daily.view.a.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        ab<bh> aZV = a.this.aZV();
                        if (aZV != null) {
                            view.setTag("1");
                            aZV.a(view, a.this.cqG);
                        }
                        a.this.ash();
                    }
                });
                this.eMr.setImageMediaList(linkedList);
            } else {
                this.eMr.setVisibility(8);
                this.gev.setVisibility(0);
            }
        } else {
            this.eMr.setVisibility(8);
            this.gev.setVisibility(0);
        }
        this.dSA.cqc = this.currentPageType;
        this.dSA.setData(this.cqG);
        bnq();
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean ag(bh bhVar) {
        SpannableStringBuilder s = bhVar.s(false, true);
        if (s == null || StringUtils.isNull(s.toString())) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setOnTouchListener(new k(s));
            this.mTitle.setText(s);
            n.a(this.mTitle, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btd() {
        if (n.uA(this.cqG.getId())) {
            n.a(this.mTitle, this.cqG.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private void bnq() {
        if (this.mTitle != null && this.HH != null && this.eMr != null && this.mContext != null && this.mTitle.getVisibility() == 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.HH.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
            this.HH.setLayoutParams(layoutParams);
            if (this.HH.getVisibility() == 8) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eMr.getLayoutParams();
                layoutParams2.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                this.eMr.setLayoutParams(layoutParams2);
            }
        }
    }

    private void iI(boolean z) {
        if (this.eMr != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eMr.getLayoutParams();
            if (z) {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16);
            } else {
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10);
            }
            this.eMr.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ash() {
        if (this.cqG != null) {
            n.uz(this.cqG.getId());
            n.a(this.mTitle, this.cqG.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.cqG, null, this.mStType, RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.cqG.akq() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.cqG.getFid()));
                createFromThreadCfg.setForumName(this.cqG.aiJ());
            } else {
                createFromThreadCfg.setForumId(this.cqG.akq().getForumId());
                createFromThreadCfg.setForumName(this.cqG.akq().getForumName());
            }
            createFromThreadCfg.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public int btq() {
        if (this.gfw == null || this.gfw.getHeaderImg() == null) {
            return -1;
        }
        return this.gfw.getHeaderImg().getId();
    }

    public int btr() {
        if (this.gfw == null || this.gfw.getForumName() == null) {
            return -1;
        }
        return this.gfw.getForumName().getId();
    }

    public int bts() {
        if (this.gfw == null || this.gfw.getForumName() == null) {
            return -1;
        }
        return this.gfw.getForumName().getId();
    }

    public void setShareReportFrom(int i) {
        if (this.dSA != null) {
            this.dSA.setShareReportFrom(i);
        }
    }

    public void sF(int i) {
        if (this.dSA != null) {
            this.dSA.setFrom(i);
        }
    }

    public void setStType(String str) {
        this.mStType = str;
        if (this.dSA != null) {
            this.dSA.setStType(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
