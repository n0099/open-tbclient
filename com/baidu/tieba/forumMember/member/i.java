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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private LikeModel crO;
    private int equ;
    private int frc;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.equ = 0;
        this.frc = 0;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.m item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == R.id.like_btn) {
                            if (bc.checkUpIsLogin(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    i.this.mPageContext.showToast(R.string.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.crO.dY(jVar.getForumName(), forumId);
                            }
                        } else if (view.getId() == R.id.user_level_name) {
                            String forumId2 = jVar.getForumId();
                            i.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_TBTITLE_ACTIVITY, new TbTitleActivityConfig(i.this.mContext, jVar.getForumName(), forumId2)));
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aF */
    public k b(ViewGroup viewGroup) {
        if (this.crO == null) {
            aJT();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) kVar);
        if (jVar != null && jVar.biw() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = am.getColor(R.color.cp_cont_d);
            com.baidu.tieba.tbadkCore.t biw = jVar.biw();
            if (TbadkCoreApplication.isLogin()) {
                if (biw.isLike() == 1) {
                    kVar.frg.setVisibility(8);
                    kVar.frh.setVisibility(0);
                    kVar.frh.setText(R.string.mydegree);
                    am.setImageResource(kVar.fqe, BitmapHelper.getSmallGradeResourceIdNew(biw.clO()));
                    if (StringUtils.isNull(biw.getLevelName())) {
                        kVar.fqf.setVisibility(8);
                    } else {
                        kVar.fqf.setText(biw.getLevelName());
                        kVar.fqf.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(biw.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + biw.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.frj.setText(spannableStringBuilder);
                    kVar.frj.setVisibility(0);
                    kVar.frn.setVisibility(0);
                    kVar.fro.setVisibility(0);
                } else {
                    kVar.frg.setVisibility(0);
                    kVar.frh.setVisibility(8);
                    kVar.fqe.setVisibility(8);
                    kVar.fqf.setVisibility(8);
                    kVar.frj.setVisibility(8);
                    kVar.frn.setVisibility(8);
                    kVar.fro.setVisibility(8);
                }
            } else {
                kVar.frg.setVisibility(8);
                kVar.frh.setVisibility(8);
                kVar.fqe.setVisibility(8);
                kVar.fqf.setVisibility(8);
                kVar.frj.setVisibility(8);
                kVar.frn.setVisibility(8);
                kVar.fro.setVisibility(8);
            }
            kVar.frg.setTag(Integer.valueOf(i));
            kVar.fqf.setTag(Integer.valueOf(i));
            kVar.fqf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            am.setBackgroundColor(kVar.frk, R.color.cp_bg_line_d);
            am.setBackgroundColor(kVar.bgU, R.color.cp_bg_line_c);
            am.setBackgroundColor(kVar.frl, R.color.cp_bg_line_c);
            am.setBackgroundResource(kVar.frg, R.drawable.frs_btn_like);
            am.setViewTextColor(kVar.frg, R.color.white_alpha100, 1);
            am.setViewTextColor(kVar.frh, R.color.cp_cont_b, 1);
            am.setViewTextColor(kVar.fqf, R.color.cp_cont_d, 1);
            am.setViewTextColor(kVar.frm, R.color.cp_cont_b, 1);
            am.setBackgroundResource(kVar.frn, R.drawable.forum_member_exp_progress);
            am.setBackgroundColor(kVar.fro, R.color.cp_bg_line_c);
            if (this.equ != biw.clO() || this.frc != biw.getCurScore()) {
                this.equ = biw.clO();
                this.frc = biw.getCurScore();
                kVar.frn.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, qa(this.equ)));
                float f = 0.0f;
                this.frc = biw.getCurScore();
                if (this.frc > biw.getLevelupScore()) {
                    this.frc = biw.getLevelupScore();
                }
                if (biw.getLevelupScore() != 0) {
                    f = this.frc / biw.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.frn, scaleAnimation, null);
            }
        }
        return view;
    }

    private void aJT() {
        if (this.mPageContext != null) {
            this.crO = new LikeModel(this.mPageContext);
            this.crO.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (!(obj instanceof com.baidu.tieba.tbadkCore.t) || i.this.crO.getErrorCode() != 0) {
                        if (AntiHelper.aG(i.this.crO.getErrorCode(), i.this.crO.getErrorString())) {
                            AntiHelper.aS(i.this.mPageContext.getPageActivity(), i.this.crO.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.crO.getErrorString());
                            return;
                        }
                    }
                    com.baidu.tieba.tbadkCore.t tVar = (com.baidu.tieba.tbadkCore.t) obj;
                    tVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                }
            });
        }
    }

    private int[] qa(int i) {
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
