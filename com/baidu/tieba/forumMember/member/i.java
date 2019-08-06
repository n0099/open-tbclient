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
    private LikeModel cdy;
    private int ecH;
    private int fqT;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.ecH = 0;
        this.fqT = 0;
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
                                i.this.cdy.el(jVar.getForumName(), forumId);
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
        if (this.cdy == null) {
            aJX();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, kVar);
        if (jVar != null && jVar.bkH() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = am.getColor(R.color.cp_cont_d);
            com.baidu.tieba.tbadkCore.t bkH = jVar.bkH();
            if (TbadkCoreApplication.isLogin()) {
                if (bkH.isLike() == 1) {
                    kVar.fqX.setVisibility(8);
                    kVar.fqY.setVisibility(0);
                    kVar.fqY.setText(R.string.mydegree);
                    am.c(kVar.fpX, BitmapHelper.getSmallGradeResourceIdNew(bkH.cnn()));
                    if (StringUtils.isNull(bkH.getLevelName())) {
                        kVar.fpY.setVisibility(8);
                    } else {
                        kVar.fpY.setText(bkH.getLevelName());
                        kVar.fpY.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(bkH.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + bkH.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.fra.setText(spannableStringBuilder);
                    kVar.fra.setVisibility(0);
                    kVar.fre.setVisibility(0);
                    kVar.frf.setVisibility(0);
                } else {
                    kVar.fqX.setVisibility(0);
                    kVar.fqY.setVisibility(8);
                    kVar.fpX.setVisibility(8);
                    kVar.fpY.setVisibility(8);
                    kVar.fra.setVisibility(8);
                    kVar.fre.setVisibility(8);
                    kVar.frf.setVisibility(8);
                }
            } else {
                kVar.fqX.setVisibility(8);
                kVar.fqY.setVisibility(8);
                kVar.fpX.setVisibility(8);
                kVar.fpY.setVisibility(8);
                kVar.fra.setVisibility(8);
                kVar.fre.setVisibility(8);
                kVar.frf.setVisibility(8);
            }
            kVar.fqX.setTag(Integer.valueOf(i));
            kVar.fpY.setTag(Integer.valueOf(i));
            kVar.fpY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            am.l(kVar.frb, R.color.cp_bg_line_d);
            am.l(kVar.aNH, R.color.cp_bg_line_b);
            am.l(kVar.frc, R.color.cp_bg_line_c);
            am.k(kVar.fqX, R.drawable.frs_btn_like);
            am.f(kVar.fqX, R.color.white_alpha100, 1);
            am.f(kVar.fqY, R.color.cp_cont_b, 1);
            am.f(kVar.fpY, R.color.cp_cont_d, 1);
            am.f(kVar.frd, R.color.cp_cont_b, 1);
            am.k(kVar.fre, R.drawable.forum_member_exp_progress);
            am.l(kVar.frf, R.color.cp_bg_line_b);
            if (this.ecH != bkH.cnn() || this.fqT != bkH.getCurScore()) {
                this.ecH = bkH.cnn();
                this.fqT = bkH.getCurScore();
                kVar.fre.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, rf(this.ecH)));
                float f = 0.0f;
                this.fqT = bkH.getCurScore();
                if (this.fqT > bkH.getLevelupScore()) {
                    this.fqT = bkH.getLevelupScore();
                }
                if (bkH.getLevelupScore() != 0) {
                    f = this.fqT / bkH.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.fre, scaleAnimation, null);
            }
        }
        return view;
    }

    private void aJX() {
        if (this.mPageContext != null) {
            this.cdy = new LikeModel(this.mPageContext);
            this.cdy.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (!(obj instanceof com.baidu.tieba.tbadkCore.t) || i.this.cdy.getErrorCode() != 0) {
                        if (AntiHelper.aG(i.this.cdy.getErrorCode(), i.this.cdy.getErrorString())) {
                            AntiHelper.aJ(i.this.mPageContext.getPageActivity(), i.this.cdy.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.cdy.getErrorString());
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

    private int[] rf(int i) {
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
