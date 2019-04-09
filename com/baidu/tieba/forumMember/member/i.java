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
    private LikeModel bUt;
    private int dOj;
    private int eVl;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dOj = 0;
        this.eVl = 0;
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
                                i.this.bUt.dW(jVar.getForumName(), forumId);
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
        if (this.bUt == null) {
            aCe();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(d.h.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, kVar);
        if (jVar != null && jVar.bbc() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = al.getColor(d.C0277d.cp_cont_d);
            com.baidu.tieba.tbadkCore.r bbc = jVar.bbc();
            if (TbadkCoreApplication.isLogin()) {
                if (bbc.isLike() == 1) {
                    kVar.eVp.setVisibility(8);
                    kVar.eVq.setVisibility(0);
                    kVar.eVq.setText(d.j.mydegree);
                    al.c(kVar.eUp, BitmapHelper.getSmallGradeResourceIdNew(bbc.cbW()));
                    if (StringUtils.isNull(bbc.getLevelName())) {
                        kVar.eUq.setVisibility(8);
                    } else {
                        kVar.eUq.setText(bbc.getLevelName());
                        kVar.eUq.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(bbc.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + bbc.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.eVs.setText(spannableStringBuilder);
                    kVar.eVs.setVisibility(0);
                    kVar.eVw.setVisibility(0);
                    kVar.eVx.setVisibility(0);
                } else {
                    kVar.eVp.setVisibility(0);
                    kVar.eVq.setVisibility(8);
                    kVar.eUp.setVisibility(8);
                    kVar.eUq.setVisibility(8);
                    kVar.eVs.setVisibility(8);
                    kVar.eVw.setVisibility(8);
                    kVar.eVx.setVisibility(8);
                }
            } else {
                kVar.eVp.setVisibility(8);
                kVar.eVq.setVisibility(8);
                kVar.eUp.setVisibility(8);
                kVar.eUq.setVisibility(8);
                kVar.eVs.setVisibility(8);
                kVar.eVw.setVisibility(8);
                kVar.eVx.setVisibility(8);
            }
            kVar.eVp.setTag(Integer.valueOf(i));
            kVar.eUq.setTag(Integer.valueOf(i));
            kVar.eUq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow12_gray66_right), (Drawable) null);
            al.l(kVar.eVt, d.C0277d.cp_bg_line_d);
            al.l(kVar.aLf, d.C0277d.cp_bg_line_b);
            al.l(kVar.eVu, d.C0277d.cp_bg_line_c);
            al.k(kVar.eVp, d.f.frs_btn_like);
            al.d(kVar.eVp, d.C0277d.white_alpha100, 1);
            al.d(kVar.eVq, d.C0277d.cp_cont_b, 1);
            al.d(kVar.eUq, d.C0277d.cp_cont_d, 1);
            al.d(kVar.eVv, d.C0277d.cp_cont_b, 1);
            al.k(kVar.eVw, d.f.forum_member_exp_progress);
            al.l(kVar.eVx, d.C0277d.cp_bg_line_b);
            if (this.dOj != bbc.cbW() || this.eVl != bbc.getCurScore()) {
                this.dOj = bbc.cbW();
                this.eVl = bbc.getCurScore();
                kVar.eVw.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, pF(this.dOj)));
                float f = 0.0f;
                this.eVl = bbc.getCurScore();
                if (this.eVl > bbc.getLevelupScore()) {
                    this.eVl = bbc.getLevelupScore();
                }
                if (bbc.getLevelupScore() != 0) {
                    f = this.eVl / bbc.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.eVw, scaleAnimation, null);
            }
        }
        return view;
    }

    private void aCe() {
        if (this.mPageContext != null) {
            this.bUt = new LikeModel(this.mPageContext);
            this.bUt.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || i.this.bUt.getErrorCode() != 0) {
                        if (AntiHelper.aD(i.this.bUt.getErrorCode(), i.this.bUt.getErrorString())) {
                            AntiHelper.aU(i.this.mPageContext.getPageActivity(), i.this.bUt.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.bUt.getErrorString());
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

    private int[] pF(int i) {
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
