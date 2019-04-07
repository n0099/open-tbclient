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
    private LikeModel bUs;
    private int dOi;
    private int eVk;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dOi = 0;
        this.eVk = 0;
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
                                i.this.bUs.dW(jVar.getForumName(), forumId);
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
        if (this.bUs == null) {
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
                    kVar.eVo.setVisibility(8);
                    kVar.eVp.setVisibility(0);
                    kVar.eVp.setText(d.j.mydegree);
                    al.c(kVar.eUo, BitmapHelper.getSmallGradeResourceIdNew(bbc.cbW()));
                    if (StringUtils.isNull(bbc.getLevelName())) {
                        kVar.eUp.setVisibility(8);
                    } else {
                        kVar.eUp.setText(bbc.getLevelName());
                        kVar.eUp.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(bbc.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + bbc.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.eVr.setText(spannableStringBuilder);
                    kVar.eVr.setVisibility(0);
                    kVar.eVv.setVisibility(0);
                    kVar.eVw.setVisibility(0);
                } else {
                    kVar.eVo.setVisibility(0);
                    kVar.eVp.setVisibility(8);
                    kVar.eUo.setVisibility(8);
                    kVar.eUp.setVisibility(8);
                    kVar.eVr.setVisibility(8);
                    kVar.eVv.setVisibility(8);
                    kVar.eVw.setVisibility(8);
                }
            } else {
                kVar.eVo.setVisibility(8);
                kVar.eVp.setVisibility(8);
                kVar.eUo.setVisibility(8);
                kVar.eUp.setVisibility(8);
                kVar.eVr.setVisibility(8);
                kVar.eVv.setVisibility(8);
                kVar.eVw.setVisibility(8);
            }
            kVar.eVo.setTag(Integer.valueOf(i));
            kVar.eUp.setTag(Integer.valueOf(i));
            kVar.eUp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow12_gray66_right), (Drawable) null);
            al.l(kVar.eVs, d.C0277d.cp_bg_line_d);
            al.l(kVar.aLe, d.C0277d.cp_bg_line_b);
            al.l(kVar.eVt, d.C0277d.cp_bg_line_c);
            al.k(kVar.eVo, d.f.frs_btn_like);
            al.d(kVar.eVo, d.C0277d.white_alpha100, 1);
            al.d(kVar.eVp, d.C0277d.cp_cont_b, 1);
            al.d(kVar.eUp, d.C0277d.cp_cont_d, 1);
            al.d(kVar.eVu, d.C0277d.cp_cont_b, 1);
            al.k(kVar.eVv, d.f.forum_member_exp_progress);
            al.l(kVar.eVw, d.C0277d.cp_bg_line_b);
            if (this.dOi != bbc.cbW() || this.eVk != bbc.getCurScore()) {
                this.dOi = bbc.cbW();
                this.eVk = bbc.getCurScore();
                kVar.eVv.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, pF(this.dOi)));
                float f = 0.0f;
                this.eVk = bbc.getCurScore();
                if (this.eVk > bbc.getLevelupScore()) {
                    this.eVk = bbc.getLevelupScore();
                }
                if (bbc.getLevelupScore() != 0) {
                    f = this.eVk / bbc.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.eVv, scaleAnimation, null);
            }
        }
        return view;
    }

    private void aCe() {
        if (this.mPageContext != null) {
            this.bUs = new LikeModel(this.mPageContext);
            this.bUs.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || i.this.bUs.getErrorCode() != 0) {
                        if (AntiHelper.aD(i.this.bUs.getErrorCode(), i.this.bUs.getErrorString())) {
                            AntiHelper.aU(i.this.mPageContext.getPageActivity(), i.this.bUs.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.bUs.getErrorString());
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
