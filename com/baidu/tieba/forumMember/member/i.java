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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes5.dex */
public class i extends com.baidu.tieba.frs.h<j, k> {
    private LikeModel cdr;
    private int ecA;
    private int fqu;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.ecA = 0;
        this.fqu = 0;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.m item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == R.id.like_btn) {
                            if (bd.cF(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.kc()) {
                                    i.this.mPageContext.showToast(R.string.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.cdr.el(jVar.getForumName(), forumId);
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
        if (this.cdr == null) {
            aJV();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, kVar);
        if (jVar != null && jVar.bkA() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = am.getColor(R.color.cp_cont_d);
            com.baidu.tieba.tbadkCore.r bkA = jVar.bkA();
            if (TbadkCoreApplication.isLogin()) {
                if (bkA.isLike() == 1) {
                    kVar.fqy.setVisibility(8);
                    kVar.fqz.setVisibility(0);
                    kVar.fqz.setText(R.string.mydegree);
                    am.c(kVar.fpy, BitmapHelper.getSmallGradeResourceIdNew(bkA.cmV()));
                    if (StringUtils.isNull(bkA.getLevelName())) {
                        kVar.fpz.setVisibility(8);
                    } else {
                        kVar.fpz.setText(bkA.getLevelName());
                        kVar.fpz.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(bkA.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + bkA.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.fqB.setText(spannableStringBuilder);
                    kVar.fqB.setVisibility(0);
                    kVar.fqF.setVisibility(0);
                    kVar.fqG.setVisibility(0);
                } else {
                    kVar.fqy.setVisibility(0);
                    kVar.fqz.setVisibility(8);
                    kVar.fpy.setVisibility(8);
                    kVar.fpz.setVisibility(8);
                    kVar.fqB.setVisibility(8);
                    kVar.fqF.setVisibility(8);
                    kVar.fqG.setVisibility(8);
                }
            } else {
                kVar.fqy.setVisibility(8);
                kVar.fqz.setVisibility(8);
                kVar.fpy.setVisibility(8);
                kVar.fpz.setVisibility(8);
                kVar.fqB.setVisibility(8);
                kVar.fqF.setVisibility(8);
                kVar.fqG.setVisibility(8);
            }
            kVar.fqy.setTag(Integer.valueOf(i));
            kVar.fpz.setTag(Integer.valueOf(i));
            kVar.fpz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            am.l(kVar.fqC, R.color.cp_bg_line_d);
            am.l(kVar.aNH, R.color.cp_bg_line_b);
            am.l(kVar.fqD, R.color.cp_bg_line_c);
            am.k(kVar.fqy, R.drawable.frs_btn_like);
            am.f(kVar.fqy, R.color.white_alpha100, 1);
            am.f(kVar.fqz, R.color.cp_cont_b, 1);
            am.f(kVar.fpz, R.color.cp_cont_d, 1);
            am.f(kVar.fqE, R.color.cp_cont_b, 1);
            am.k(kVar.fqF, R.drawable.forum_member_exp_progress);
            am.l(kVar.fqG, R.color.cp_bg_line_b);
            if (this.ecA != bkA.cmV() || this.fqu != bkA.getCurScore()) {
                this.ecA = bkA.cmV();
                this.fqu = bkA.getCurScore();
                kVar.fqF.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, rd(this.ecA)));
                float f = 0.0f;
                this.fqu = bkA.getCurScore();
                if (this.fqu > bkA.getLevelupScore()) {
                    this.fqu = bkA.getLevelupScore();
                }
                if (bkA.getLevelupScore() != 0) {
                    f = this.fqu / bkA.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.fqF, scaleAnimation, null);
            }
        }
        return view;
    }

    private void aJV() {
        if (this.mPageContext != null) {
            this.cdr = new LikeModel(this.mPageContext);
            this.cdr.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || i.this.cdr.getErrorCode() != 0) {
                        if (AntiHelper.aG(i.this.cdr.getErrorCode(), i.this.cdr.getErrorString())) {
                            AntiHelper.aJ(i.this.mPageContext.getPageActivity(), i.this.cdr.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.cdr.getErrorString());
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

    private int[] rd(int i) {
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
