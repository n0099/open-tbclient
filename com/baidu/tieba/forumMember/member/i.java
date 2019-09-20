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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes5.dex */
public class i extends com.baidu.tieba.frs.h<j, k> {
    private LikeModel cer;
    private int eer;
    private int fsH;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.eer = 0;
        this.fsH = 0;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.m item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == R.id.like_btn) {
                            if (bc.cF(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.kc()) {
                                    i.this.mPageContext.showToast(R.string.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.cer.em(jVar.getForumName(), forumId);
                            }
                        } else if (view.getId() == R.id.user_level_name) {
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
    /* renamed from: aD */
    public k onCreateViewHolder(ViewGroup viewGroup) {
        if (this.cer == null) {
            aKB();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, kVar);
        if (jVar != null && jVar.bls() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = am.getColor(R.color.cp_cont_d);
            com.baidu.tieba.tbadkCore.t bls = jVar.bls();
            if (TbadkCoreApplication.isLogin()) {
                if (bls.isLike() == 1) {
                    kVar.fsL.setVisibility(8);
                    kVar.fsM.setVisibility(0);
                    kVar.fsM.setText(R.string.mydegree);
                    am.c(kVar.frL, BitmapHelper.getSmallGradeResourceIdNew(bls.coa()));
                    if (StringUtils.isNull(bls.getLevelName())) {
                        kVar.frM.setVisibility(8);
                    } else {
                        kVar.frM.setText(bls.getLevelName());
                        kVar.frM.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(bls.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + bls.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.fsO.setText(spannableStringBuilder);
                    kVar.fsO.setVisibility(0);
                    kVar.fsS.setVisibility(0);
                    kVar.fsT.setVisibility(0);
                } else {
                    kVar.fsL.setVisibility(0);
                    kVar.fsM.setVisibility(8);
                    kVar.frL.setVisibility(8);
                    kVar.frM.setVisibility(8);
                    kVar.fsO.setVisibility(8);
                    kVar.fsS.setVisibility(8);
                    kVar.fsT.setVisibility(8);
                }
            } else {
                kVar.fsL.setVisibility(8);
                kVar.fsM.setVisibility(8);
                kVar.frL.setVisibility(8);
                kVar.frM.setVisibility(8);
                kVar.fsO.setVisibility(8);
                kVar.fsS.setVisibility(8);
                kVar.fsT.setVisibility(8);
            }
            kVar.fsL.setTag(Integer.valueOf(i));
            kVar.frM.setTag(Integer.valueOf(i));
            kVar.frM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            am.l(kVar.fsP, R.color.cp_bg_line_d);
            am.l(kVar.aOf, R.color.cp_bg_line_c);
            am.l(kVar.fsQ, R.color.cp_bg_line_c);
            am.k(kVar.fsL, R.drawable.frs_btn_like);
            am.f(kVar.fsL, R.color.white_alpha100, 1);
            am.f(kVar.fsM, R.color.cp_cont_b, 1);
            am.f(kVar.frM, R.color.cp_cont_d, 1);
            am.f(kVar.fsR, R.color.cp_cont_b, 1);
            am.k(kVar.fsS, R.drawable.forum_member_exp_progress);
            am.l(kVar.fsT, R.color.cp_bg_line_c);
            if (this.eer != bls.coa() || this.fsH != bls.getCurScore()) {
                this.eer = bls.coa();
                this.fsH = bls.getCurScore();
                kVar.fsS.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ri(this.eer)));
                float f = 0.0f;
                this.fsH = bls.getCurScore();
                if (this.fsH > bls.getLevelupScore()) {
                    this.fsH = bls.getLevelupScore();
                }
                if (bls.getLevelupScore() != 0) {
                    f = this.fsH / bls.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.fsS, scaleAnimation, null);
            }
        }
        return view;
    }

    private void aKB() {
        if (this.mPageContext != null) {
            this.cer = new LikeModel(this.mPageContext);
            this.cer.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (!(obj instanceof com.baidu.tieba.tbadkCore.t) || i.this.cer.getErrorCode() != 0) {
                        if (AntiHelper.aG(i.this.cer.getErrorCode(), i.this.cer.getErrorString())) {
                            AntiHelper.aQ(i.this.mPageContext.getPageActivity(), i.this.cer.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.cer.getErrorString());
                            return;
                        }
                    }
                    com.baidu.tieba.tbadkCore.t tVar = (com.baidu.tieba.tbadkCore.t) obj;
                    tVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, tVar));
                }
            });
        }
    }

    private int[] ri(int i) {
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
