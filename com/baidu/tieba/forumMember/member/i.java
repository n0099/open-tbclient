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
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes10.dex */
public class i extends com.baidu.tieba.frs.h<j, k> {
    private LikeModel dKs;
    private int fSc;
    private int gUT;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.fSc = 0;
        this.gUT = 0;
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
                                i.this.dKs.eP(jVar.getForumName(), forumId);
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
    /* renamed from: aL */
    public k b(ViewGroup viewGroup) {
        if (this.dKs == null) {
            blZ();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) kVar);
        if (jVar != null && jVar.bNd() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = am.getColor(R.color.cp_cont_d);
            u bNd = jVar.bNd();
            if (TbadkCoreApplication.isLogin()) {
                if (bNd.isLike() == 1) {
                    kVar.gUX.setVisibility(8);
                    kVar.gUY.setVisibility(0);
                    kVar.gUY.setText(R.string.mydegree);
                    am.setImageResource(kVar.gTV, BitmapHelper.getSmallGradeResourceIdNew(bNd.cTG()));
                    if (StringUtils.isNull(bNd.getLevelName())) {
                        kVar.gTW.setVisibility(8);
                    } else {
                        kVar.gTW.setText(bNd.getLevelName());
                        kVar.gTW.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(bNd.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + bNd.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.gVa.setText(spannableStringBuilder);
                    kVar.gVa.setVisibility(0);
                    kVar.gVe.setVisibility(0);
                    kVar.gVf.setVisibility(0);
                } else {
                    kVar.gUX.setVisibility(0);
                    kVar.gUY.setVisibility(8);
                    kVar.gTV.setVisibility(8);
                    kVar.gTW.setVisibility(8);
                    kVar.gVa.setVisibility(8);
                    kVar.gVe.setVisibility(8);
                    kVar.gVf.setVisibility(8);
                }
            } else {
                kVar.gUX.setVisibility(8);
                kVar.gUY.setVisibility(8);
                kVar.gTV.setVisibility(8);
                kVar.gTW.setVisibility(8);
                kVar.gVa.setVisibility(8);
                kVar.gVe.setVisibility(8);
                kVar.gVf.setVisibility(8);
            }
            kVar.gUX.setTag(Integer.valueOf(i));
            kVar.gTW.setTag(Integer.valueOf(i));
            kVar.gTW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            am.setBackgroundColor(kVar.gVb, R.color.cp_bg_line_d);
            am.setBackgroundColor(kVar.mDivider, R.color.cp_bg_line_c);
            am.setBackgroundColor(kVar.gVc, R.color.cp_bg_line_c);
            am.setBackgroundResource(kVar.gUX, R.drawable.frs_btn_like);
            am.setViewTextColor(kVar.gUX, R.color.white_alpha100, 1);
            am.setViewTextColor(kVar.gUY, R.color.cp_cont_b, 1);
            am.setViewTextColor(kVar.gTW, R.color.cp_cont_d, 1);
            am.setViewTextColor(kVar.gVd, R.color.cp_cont_b, 1);
            am.setBackgroundResource(kVar.gVe, R.drawable.forum_member_exp_progress);
            am.setBackgroundColor(kVar.gVf, R.color.cp_bg_line_c);
            if (this.fSc != bNd.cTG() || this.gUT != bNd.getCurScore()) {
                this.fSc = bNd.cTG();
                this.gUT = bNd.getCurScore();
                kVar.gVe.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, sQ(this.fSc)));
                float f = 0.0f;
                this.gUT = bNd.getCurScore();
                if (this.gUT > bNd.getLevelupScore()) {
                    this.gUT = bNd.getLevelupScore();
                }
                if (bNd.getLevelupScore() != 0) {
                    f = this.gUT / bNd.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.gVe, scaleAnimation, null);
            }
        }
        return view;
    }

    private void blZ() {
        if (this.mPageContext != null) {
            this.dKs = new LikeModel(this.mPageContext);
            this.dKs.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (!(obj instanceof u) || i.this.dKs.getErrorCode() != 0) {
                        if (AntiHelper.bq(i.this.dKs.getErrorCode(), i.this.dKs.getErrorString())) {
                            AntiHelper.aW(i.this.mPageContext.getPageActivity(), i.this.dKs.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.dKs.getErrorString());
                            return;
                        }
                    }
                    u uVar = (u) obj;
                    uVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                }
            });
        }
    }

    private int[] sQ(int i) {
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
