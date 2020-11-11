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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes23.dex */
public class i extends com.baidu.tieba.frs.k<j, k> {
    private LikeModel eZA;
    private int hwa;
    private int iDz;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.hwa = 0;
        this.iDz = 0;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.q item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == R.id.like_btn) {
                            if (bg.checkUpIsLogin(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    i.this.mPageContext.showToast(R.string.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.eZA.gp(jVar.getForumName(), forumId);
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
    /* renamed from: bg */
    public k c(ViewGroup viewGroup) {
        if (this.eZA == null) {
            bPJ();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) kVar);
        if (jVar != null && jVar.cwG() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = ap.getColor(R.color.cp_cont_d);
            v cwG = jVar.cwG();
            if (TbadkCoreApplication.isLogin()) {
                if (cwG.isLike() == 1) {
                    kVar.iDD.setVisibility(8);
                    kVar.iDE.setVisibility(0);
                    kVar.iDE.setText(R.string.mydegree);
                    ap.setImageResource(kVar.iCC, BitmapHelper.getSmallGradeResourceIdNew(cwG.dHo()));
                    if (StringUtils.isNull(cwG.getLevelName())) {
                        kVar.iCD.setVisibility(8);
                    } else {
                        kVar.iCD.setText(cwG.getLevelName());
                        kVar.iCD.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(cwG.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + cwG.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.eSV.setText(spannableStringBuilder);
                    kVar.eSV.setVisibility(0);
                    kVar.iDJ.setVisibility(0);
                    kVar.iDK.setVisibility(0);
                } else {
                    kVar.iDD.setVisibility(0);
                    kVar.iDE.setVisibility(8);
                    kVar.iCC.setVisibility(8);
                    kVar.iCD.setVisibility(8);
                    kVar.eSV.setVisibility(8);
                    kVar.iDJ.setVisibility(8);
                    kVar.iDK.setVisibility(8);
                }
            } else {
                kVar.iDD.setVisibility(8);
                kVar.iDE.setVisibility(8);
                kVar.iCC.setVisibility(8);
                kVar.iCD.setVisibility(8);
                kVar.eSV.setVisibility(8);
                kVar.iDJ.setVisibility(8);
                kVar.iDK.setVisibility(8);
            }
            kVar.iDD.setTag(Integer.valueOf(i));
            kVar.iCD.setTag(Integer.valueOf(i));
            kVar.iCD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            ap.setBackgroundColor(kVar.iDG, R.color.cp_bg_line_d);
            ap.setBackgroundColor(kVar.mDivider, R.color.cp_bg_line_c);
            ap.setBackgroundColor(kVar.iDH, R.color.cp_bg_line_c);
            ap.setBackgroundResource(kVar.iDD, R.drawable.frs_btn_like);
            ap.setViewTextColor(kVar.iDD, R.color.white_alpha100, 1);
            ap.setViewTextColor(kVar.iDE, R.color.cp_cont_b, 1);
            ap.setViewTextColor(kVar.iCD, R.color.cp_cont_d, 1);
            ap.setViewTextColor(kVar.iDI, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(kVar.iDJ, R.drawable.forum_member_exp_progress);
            ap.setBackgroundColor(kVar.iDK, R.color.cp_bg_line_c);
            if (this.hwa != cwG.dHo() || this.iDz != cwG.getCurScore()) {
                this.hwa = cwG.dHo();
                this.iDz = cwG.getCurScore();
                kVar.iDJ.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, yq(this.hwa)));
                float f = 0.0f;
                this.iDz = cwG.getCurScore();
                if (this.iDz > cwG.getLevelupScore()) {
                    this.iDz = cwG.getLevelupScore();
                }
                if (cwG.getLevelupScore() != 0) {
                    f = this.iDz / cwG.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.iDJ, scaleAnimation, null);
            }
        }
        return view;
    }

    private void bPJ() {
        if (this.mPageContext != null) {
            this.eZA = new LikeModel(this.mPageContext);
            this.eZA.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (!(obj instanceof v) || i.this.eZA.getErrorCode() != 0) {
                        if (AntiHelper.bR(i.this.eZA.getErrorCode(), i.this.eZA.getErrorString())) {
                            AntiHelper.bm(i.this.mPageContext.getPageActivity(), i.this.eZA.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.eZA.getErrorString());
                            return;
                        }
                    }
                    v vVar = (v) obj;
                    vVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                }
            });
        }
    }

    private int[] yq(int i) {
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
