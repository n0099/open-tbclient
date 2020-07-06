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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes10.dex */
public class i extends com.baidu.tieba.frs.j<j, k> {
    private LikeModel egK;
    private int gtU;
    private int hvY;
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.gtU = 0;
        this.hvY = 0;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    com.baidu.adp.widget.ListView.q item = i.this.getItem(((Integer) tag).intValue());
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (view.getId() == R.id.like_btn) {
                            if (be.checkUpIsLogin(i.this.mPageContext.getPageActivity())) {
                                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    i.this.mPageContext.showToast(R.string.neterror);
                                    return;
                                }
                                String forumId = jVar.getForumId();
                                i.this.egK.fx(jVar.getForumName(), forumId);
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
    /* renamed from: bb */
    public k b(ViewGroup viewGroup) {
        if (this.egK == null) {
            buw();
        }
        return new k(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_head_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, k kVar) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) kVar);
        if (jVar != null && jVar.bWx() != null) {
            int parseColor = Color.parseColor("#56cfa1");
            int color = an.getColor(R.color.cp_cont_d);
            u bWx = jVar.bWx();
            if (TbadkCoreApplication.isLogin()) {
                if (bWx.isLike() == 1) {
                    kVar.hwc.setVisibility(8);
                    kVar.hwd.setVisibility(0);
                    kVar.hwd.setText(R.string.mydegree);
                    an.setImageResource(kVar.hvb, BitmapHelper.getSmallGradeResourceIdNew(bWx.dfr()));
                    if (StringUtils.isNull(bWx.getLevelName())) {
                        kVar.hvc.setVisibility(8);
                    } else {
                        kVar.hvc.setText(bWx.getLevelName());
                        kVar.hvc.setVisibility(0);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(bWx.getCurScore() + "");
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), 0, spannableString.length(), 17);
                    SpannableString spannableString2 = new SpannableString("/" + bWx.getLevelupScore());
                    spannableString2.setSpan(new ForegroundColorSpan(color), 0, spannableString2.length(), 17);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) spannableString2);
                    kVar.eay.setText(spannableStringBuilder);
                    kVar.eay.setVisibility(0);
                    kVar.hwi.setVisibility(0);
                    kVar.hwj.setVisibility(0);
                } else {
                    kVar.hwc.setVisibility(0);
                    kVar.hwd.setVisibility(8);
                    kVar.hvb.setVisibility(8);
                    kVar.hvc.setVisibility(8);
                    kVar.eay.setVisibility(8);
                    kVar.hwi.setVisibility(8);
                    kVar.hwj.setVisibility(8);
                }
            } else {
                kVar.hwc.setVisibility(8);
                kVar.hwd.setVisibility(8);
                kVar.hvb.setVisibility(8);
                kVar.hvc.setVisibility(8);
                kVar.eay.setVisibility(8);
                kVar.hwi.setVisibility(8);
                kVar.hwj.setVisibility(8);
            }
            kVar.hwc.setTag(Integer.valueOf(i));
            kVar.hvc.setTag(Integer.valueOf(i));
            kVar.hvc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, an.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            an.setBackgroundColor(kVar.hwf, R.color.cp_bg_line_d);
            an.setBackgroundColor(kVar.mDivider, R.color.cp_bg_line_c);
            an.setBackgroundColor(kVar.hwg, R.color.cp_bg_line_c);
            an.setBackgroundResource(kVar.hwc, R.drawable.frs_btn_like);
            an.setViewTextColor(kVar.hwc, R.color.white_alpha100, 1);
            an.setViewTextColor(kVar.hwd, R.color.cp_cont_b, 1);
            an.setViewTextColor(kVar.hvc, R.color.cp_cont_d, 1);
            an.setViewTextColor(kVar.hwh, R.color.cp_cont_b, 1);
            an.setBackgroundResource(kVar.hwi, R.drawable.forum_member_exp_progress);
            an.setBackgroundColor(kVar.hwj, R.color.cp_bg_line_c);
            if (this.gtU != bWx.dfr() || this.hvY != bWx.getCurScore()) {
                this.gtU = bWx.dfr();
                this.hvY = bWx.getCurScore();
                kVar.hwi.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, tY(this.gtU)));
                float f = 0.0f;
                this.hvY = bWx.getCurScore();
                if (this.hvY > bWx.getLevelupScore()) {
                    this.hvY = bWx.getLevelupScore();
                }
                if (bWx.getLevelupScore() != 0) {
                    f = this.hvY / bWx.getLevelupScore();
                }
                if (f > 0.999f) {
                    f = 1.0f;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, f, 1.0f, 1.0f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setDuration(1000L);
                com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) this.mPageContext.getPageActivity(), kVar.hwi, scaleAnimation, null);
            }
        }
        return view;
    }

    private void buw() {
        if (this.mPageContext != null) {
            this.egK = new LikeModel(this.mPageContext);
            this.egK.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.member.i.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    if (!(obj instanceof u) || i.this.egK.getErrorCode() != 0) {
                        if (AntiHelper.bA(i.this.egK.getErrorCode(), i.this.egK.getErrorString())) {
                            AntiHelper.aX(i.this.mPageContext.getPageActivity(), i.this.egK.getErrorString());
                            return;
                        } else {
                            i.this.mPageContext.showToast(i.this.egK.getErrorString());
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

    private int[] tY(int i) {
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
