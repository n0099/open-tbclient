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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private View cYD;
    private TbPageContext<BaseFragmentActivity> duG;
    private HeadImageView eSi;
    private TextView fqL;
    private TbImageView gbA;
    private RelativeLayout gbB;
    private ImageView gbC;
    private LinearLayout gbD;
    private AlaNetRefreshView gbE;
    private RelativeLayout gbF;
    private TextView gbG;
    private InterfaceC0516a gbH;
    private List<AlaLiveMarkData> gbI = new ArrayList();
    private b.a gbJ = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.gbH != null) {
                a.this.gbH.a(bVar);
            }
        }
    };
    private BdListView gbx;
    private b gby;
    private TextView gbz;
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0516a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0516a interfaceC0516a) {
        this.duG = tbPageContext;
        this.gbH = interfaceC0516a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.duG.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.duG.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.eSi = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.gbz = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.gbA = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.gbF = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.gbD = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.gbG = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.gbC = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.fqL = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.cYD = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.gbx = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.gby = new b(this.duG, this.gbJ);
        this.gbx.setAdapter((ListAdapter) this.gby);
        this.gbB = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.gbx.setEmptyView(this.gbB);
        this.eSi.setIsRound(true);
        this.eSi.setDefaultBgResource(R.color.transparent);
        this.eSi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gbA.setDefaultBgResource(R.color.transparent);
        this.gbA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mName, (int) R.color.common_color_10310);
        am.setViewTextColor(this.gbz, (int) R.color.white_alpha70);
        am.setViewTextColor(this.gbG, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fqL, (int) R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.gbC.setAlpha(0.4f);
            this.cYD.setBackgroundColor(this.duG.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.gbC.setAlpha(1.0f);
        this.cYD.setBackgroundColor(this.duG.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.gby != null && list != null) {
            this.gby.setData(list);
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
                format = String.format(this.duG.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.duG.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            ag(currentPortrait, str, format);
            int dimension = (int) this.duG.getResources().getDimension(R.dimen.ds32);
            if (this.gbI != null && this.gbI.size() > 0) {
                this.gbI.clear();
            }
            if (this.gbD != null) {
                this.gbD.removeAllViews();
                this.gbI = alaUserInfoData.live_mark_info_new;
                if (this.gbI != null) {
                    for (int i = 0; i < this.gbI.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.duG.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.gbI.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.duG.getResources().getDimension(R.dimen.ds12);
                        this.gbD.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        ag(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.duG.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.gbI != null && this.gbI.size() > 0) {
            this.gbI.clear();
        }
        if (this.gbD != null) {
            this.gbD.removeAllViews();
        }
    }

    private void ag(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.eSi.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.kV().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.gbA.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.gbA.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.eSi.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.gbA.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.gbz.setText(str3);
        } else {
            this.gbz.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.duG != null) {
            if (this.gbE == null) {
                this.gbE = new AlaNetRefreshView(this.duG.getPageActivity());
            }
            this.gbE.setImageResource(i);
            this.gbE.setNetFailTipText(this.duG.getString(i2));
            this.gbE.onChangeSkinType();
            this.gbE.setIsShowRefreshButton(z);
            if (z) {
                this.gbE.setOnRefreshClickListener(onClickListener);
            }
            this.gbE.attachView(this.gbF);
        }
    }

    public void blt() {
        if (this.gbE != null) {
            this.gbE.dettachView(this.gbF);
        }
    }
}
