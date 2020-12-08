package com.baidu.tieba.ala.personcenter.privilege.achievementmark.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaLiveMarkData;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.ala.view.AlaNetRefreshView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private View dlk;
    private TbPageContext<BaseFragmentActivity> eNx;
    private TextView gZw;
    private HeadImageView gui;
    private BdListView hPo;
    private b hPp;
    private TextView hPq;
    private TbImageView hPr;
    private RelativeLayout hPs;
    private ImageView hPt;
    private LinearLayout hPu;
    private AlaNetRefreshView hPv;
    private RelativeLayout hPw;
    private TextView hPx;
    private InterfaceC0713a hPy;
    private TextView mName;
    private View mRootView;
    private List<AlaLiveMarkData> hPz = new ArrayList();
    private b.a hPA = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.hPy != null) {
                a.this.hPy.a(bVar);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0713a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0713a interfaceC0713a) {
        this.eNx = tbPageContext;
        this.hPy = interfaceC0713a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.eNx.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.gui = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.hPq = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.hPr = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.hPw = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.hPu = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.hPx = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.hPt = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.gZw = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.dlk = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.hPo = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.hPp = new b(this.eNx, this.hPA);
        this.hPo.setAdapter((ListAdapter) this.hPp);
        this.hPs = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.hPo.setEmptyView(this.hPs);
        this.gui.setIsRound(true);
        this.gui.setDefaultBgResource(R.color.transparent);
        this.gui.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hPr.setDefaultBgResource(R.color.transparent);
        this.hPr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setViewTextColor(this.mName, (int) R.color.common_color_10310);
        ap.setViewTextColor(this.hPq, (int) R.color.white_alpha70);
        ap.setViewTextColor(this.hPx, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.gZw, (int) R.color.CAM_X0106);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.hPt.setAlpha(0.4f);
            this.dlk.setBackgroundColor(this.eNx.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.hPt.setAlpha(1.0f);
        this.dlk.setBackgroundColor(this.eNx.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.hPp != null && list != null) {
            this.hPp.setData(list);
        }
        a(alaUserInfoData);
    }

    private void a(AlaUserInfoData alaUserInfoData) {
        String format;
        if (alaUserInfoData != null) {
            String str = alaUserInfoData.user_nickname;
            String str2 = alaUserInfoData.user_name;
            if (str == null) {
                str = str2 != null ? str2 : TbadkApplication.getCurrentAccountNameShow();
            }
            String currentPortrait = alaUserInfoData.portrait == null ? TbadkApplication.getCurrentPortrait() : alaUserInfoData.portrait;
            if (alaUserInfoData.mark_count == null) {
                format = String.format(this.eNx.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.eNx.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            ay(currentPortrait, str, format);
            int dimension = (int) this.eNx.getResources().getDimension(R.dimen.ds32);
            if (this.hPz != null && this.hPz.size() > 0) {
                this.hPz.clear();
            }
            if (this.hPu != null) {
                this.hPu.removeAllViews();
                this.hPz = alaUserInfoData.live_mark_info_new;
                if (this.hPz != null) {
                    for (int i = 0; i < this.hPz.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.eNx.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.hPz.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.eNx.getResources().getDimension(R.dimen.ds12);
                        this.hPu.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        ay(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.eNx.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.hPz != null && this.hPz.size() > 0) {
            this.hPz.clear();
        }
        if (this.hPu != null) {
            this.hPu.removeAllViews();
        }
    }

    private void ay(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.gui.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.mS().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.hPr.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.hPr.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.gui.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.hPr.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.hPq.setText(str3);
        } else {
            this.hPq.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.eNx != null) {
            if (this.hPv == null) {
                this.hPv = new AlaNetRefreshView(this.eNx.getPageActivity());
            }
            this.hPv.setImageResource(i);
            this.hPv.setNetFailTipText(this.eNx.getString(i2));
            this.hPv.onChangeSkinType();
            this.hPv.setIsShowRefreshButton(z);
            if (z) {
                this.hPv.setOnRefreshClickListener(onClickListener);
            }
            this.hPv.attachView(this.hPw);
        }
    }

    public void Yb() {
        if (this.hPv != null) {
            this.hPv.dettachView(this.hPw);
        }
    }
}
