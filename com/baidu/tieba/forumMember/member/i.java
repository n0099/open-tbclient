package com.baidu.tieba.forumMember.member;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes5.dex */
public class i extends com.baidu.tieba.frs.h<j, k> {
    private LikeModel bUq;
    private int dOR;
    private int eVy;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dOR = 0;
        this.eVy = 0;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.m item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == d.g.like_btn) {
                            if (bc.cZ(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.kY()) {
                                    i.this.mPageContext.showToast(d.j.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.bUq.dV(jVar.getForumName(), forumId);
                            }
                        } else if (view.getId() == d.g.user_level_name) {
                            String forumId2 = jVar.getForumId();
                            i.this.mPageContext.sendMessage(new CustomMessage(2003006, new TbTitleActivityConfig(i.this.mContext, jVar.getForumName(), forumId2)));
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: az */
    public k onCreateViewHolder(ViewGroup viewGroup) {
        if (this.bUq == null) {
            aCh();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(d.h.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, kVar);
        if (jVar != null && jVar.bbe() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = al.getColor(d.C0277d.cp_cont_d);
            com.baidu.tieba.tbadkCore.r bbe = jVar.bbe();
            if (TbadkCoreApplication.isLogin()) {
                if (bbe.isLike() == 1) {
                    kVar.eVC.setVisibility(8);
                    kVar.eVD.setVisibility(0);
                    kVar.eVD.setText(d.j.mydegree);
                    al.c(kVar.eUC, BitmapHelper.getSmallGradeResourceIdNew(bbe.cca()));
                    if (StringUtils.isNull(bbe.getLevelName())) {
                        kVar.eUD.setVisibility(8);
                    } else {
                        kVar.eUD.setText(bbe.getLevelName());
                        kVar.eUD.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(bbe.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + bbe.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.eVF.setText(spannableStringBuilder);
                    kVar.eVF.setVisibility(0);
                    kVar.eVJ.setVisibility(0);
                    kVar.eVK.setVisibility(0);
                } else {
                    kVar.eVC.setVisibility(0);
                    kVar.eVD.setVisibility(8);
                    kVar.eUC.setVisibility(8);
                    kVar.eUD.setVisibility(8);
                    kVar.eVF.setVisibility(8);
                    kVar.eVJ.setVisibility(8);
                    kVar.eVK.setVisibility(8);
                }
            } else {
                kVar.eVC.setVisibility(8);
                kVar.eVD.setVisibility(8);
                kVar.eUC.setVisibility(8);
                kVar.eUD.setVisibility(8);
                kVar.eVF.setVisibility(8);
                kVar.eVJ.setVisibility(8);
                kVar.eVK.setVisibility(8);
            }
            kVar.eVC.setTag(Integer.valueOf(i));
            kVar.eUD.setTag(Integer.valueOf(i));
            kVar.eUD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow12_gray66_right), (Drawable) null);
            al.l(kVar.eVG, d.C0277d.cp_bg_line_d);
            al.l(kVar.aLb, d.C0277d.cp_bg_line_b);
            al.l(kVar.eVH, d.C0277d.cp_bg_line_c);
            al.k(kVar.eVC, d.f.frs_btn_like);
            al.d(kVar.eVC, d.C0277d.white_alpha100, 1);
            al.d(kVar.eVD, d.C0277d.cp_cont_b, 1);
            al.d(kVar.eUD, d.C0277d.cp_cont_d, 1);
            al.d(kVar.eVI, d.C0277d.cp_cont_b, 1);
            al.k(kVar.eVJ, d.f.forum_member_exp_progress);
            al.l(kVar.eVK, d.C0277d.cp_bg_line_b);
            if (this.dOR != bbe.cca() || this.eVy != bbe.getCurScore()) {
                this.dOR = bbe.cca();
                this.eVy = bbe.getCurScore();
                kVar.eVJ.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, pJ(this.dOR)));
                float f = 0.0f;
                this.eVy = bbe.getCurScore();
                if (this.eVy > bbe.getLevelupScore()) {
                    this.eVy = bbe.getLevelupScore();
                }
                if (bbe.getLevelupScore() != 0) {
                    f = this.eVy / bbe.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.eVJ, scaleAnimation, null);
            }
        }
        return view;
    }

    private void aCh() {
        if (this.mPageContext != null) {
            this.bUq = new LikeModel(this.mPageContext);
            this.bUq.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || i.this.bUq.getErrorCode() != 0) {
                        if (AntiHelper.aB(i.this.bUq.getErrorCode(), i.this.bUq.getErrorString())) {
                            AntiHelper.aU(i.this.mPageContext.getPageActivity(), i.this.bUq.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.bUq.getErrorString());
                            return;
                        }
                    }
                    com.baidu.tieba.tbadkCore.r rVar = (com.baidu.tieba.tbadkCore.r) obj;
                    rVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                }
            });
        }
    }

    private int[] pJ(int i) {
        if (i <= 3) {
            return new int[]{-8331843, -10499102};
        }
        if (i <= 9) {
            return new int[]{-10499102, -154262};
        }
        if (i <= 15) {
            return new int[]{-154262, -148180};
        }
        return new int[]{-148180, -100818};
    }
}
