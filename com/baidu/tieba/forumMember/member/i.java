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
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes5.dex */
public class i extends com.baidu.tieba.frs.h<j, k> {
    private LikeModel cco;
    private int dYJ;
    private int flw;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.dYJ = 0;
        this.flw = 0;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.m item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == R.id.like_btn) {
                            if (bc.cE(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.jS()) {
                                    i.this.mPageContext.showToast(R.string.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.cco.ek(jVar.getForumName(), forumId);
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
    /* renamed from: az */
    public k onCreateViewHolder(ViewGroup viewGroup) {
        if (this.cco == null) {
            aIu();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.onFillViewHolder(i, view, viewGroup, jVar, kVar);
        if (jVar != null && jVar.biy() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = al.getColor(R.color.cp_cont_d);
            com.baidu.tieba.tbadkCore.r biy = jVar.biy();
            if (TbadkCoreApplication.isLogin()) {
                if (biy.isLike() == 1) {
                    kVar.flA.setVisibility(8);
                    kVar.flB.setVisibility(0);
                    kVar.flB.setText(R.string.mydegree);
                    al.c(kVar.fkA, BitmapHelper.getSmallGradeResourceIdNew(biy.cke()));
                    if (StringUtils.isNull(biy.getLevelName())) {
                        kVar.fkB.setVisibility(8);
                    } else {
                        kVar.fkB.setText(biy.getLevelName());
                        kVar.fkB.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(biy.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + biy.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.flD.setText(spannableStringBuilder);
                    kVar.flD.setVisibility(0);
                    kVar.flH.setVisibility(0);
                    kVar.flI.setVisibility(0);
                } else {
                    kVar.flA.setVisibility(0);
                    kVar.flB.setVisibility(8);
                    kVar.fkA.setVisibility(8);
                    kVar.fkB.setVisibility(8);
                    kVar.flD.setVisibility(8);
                    kVar.flH.setVisibility(8);
                    kVar.flI.setVisibility(8);
                }
            } else {
                kVar.flA.setVisibility(8);
                kVar.flB.setVisibility(8);
                kVar.fkA.setVisibility(8);
                kVar.fkB.setVisibility(8);
                kVar.flD.setVisibility(8);
                kVar.flH.setVisibility(8);
                kVar.flI.setVisibility(8);
            }
            kVar.flA.setTag(Integer.valueOf(i));
            kVar.fkB.setTag(Integer.valueOf(i));
            kVar.fkB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            al.l(kVar.flE, R.color.cp_bg_line_d);
            al.l(kVar.aMY, R.color.cp_bg_line_b);
            al.l(kVar.flF, R.color.cp_bg_line_c);
            al.k(kVar.flA, R.drawable.frs_btn_like);
            al.f(kVar.flA, R.color.white_alpha100, 1);
            al.f(kVar.flB, R.color.cp_cont_b, 1);
            al.f(kVar.fkB, R.color.cp_cont_d, 1);
            al.f(kVar.flG, R.color.cp_cont_b, 1);
            al.k(kVar.flH, R.drawable.forum_member_exp_progress);
            al.l(kVar.flI, R.color.cp_bg_line_b);
            if (this.dYJ != biy.cke() || this.flw != biy.getCurScore()) {
                this.dYJ = biy.cke();
                this.flw = biy.getCurScore();
                kVar.flH.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, qL(this.dYJ)));
                float f = 0.0f;
                this.flw = biy.getCurScore();
                if (this.flw > biy.getLevelupScore()) {
                    this.flw = biy.getLevelupScore();
                }
                if (biy.getLevelupScore() != 0) {
                    f = this.flw / biy.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.flH, scaleAnimation, null);
            }
        }
        return view;
    }

    private void aIu() {
        if (this.mPageContext != null) {
            this.cco = new LikeModel(this.mPageContext);
            this.cco.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    if (!(obj instanceof com.baidu.tieba.tbadkCore.r) || i.this.cco.getErrorCode() != 0) {
                        if (AntiHelper.aG(i.this.cco.getErrorCode(), i.this.cco.getErrorString())) {
                            AntiHelper.aI(i.this.mPageContext.getPageActivity(), i.this.cco.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.cco.getErrorString());
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

    private int[] qL(int i) {
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
