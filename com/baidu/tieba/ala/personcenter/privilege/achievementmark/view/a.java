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
/* loaded from: classes4.dex */
public class a {
    private View del;
    private TbPageContext<BaseFragmentActivity> eGu;
    private TextView gQj;
    private HeadImageView glZ;
    private BdListView hFH;
    private b hFI;
    private TextView hFJ;
    private TbImageView hFK;
    private RelativeLayout hFL;
    private ImageView hFM;
    private LinearLayout hFN;
    private AlaNetRefreshView hFO;
    private RelativeLayout hFP;
    private TextView hFQ;
    private InterfaceC0700a hFR;
    private List<AlaLiveMarkData> hFS = new ArrayList();
    private b.a hFT = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.hFR != null) {
                a.this.hFR.a(bVar);
            }
        }
    };
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0700a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0700a interfaceC0700a) {
        this.eGu = tbPageContext;
        this.hFR = interfaceC0700a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.eGu.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.glZ = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.hFJ = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.hFK = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.hFP = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.hFN = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.hFQ = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.hFM = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.gQj = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.del = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.hFH = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.hFI = new b(this.eGu, this.hFT);
        this.hFH.setAdapter((ListAdapter) this.hFI);
        this.hFL = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.hFH.setEmptyView(this.hFL);
        this.glZ.setIsRound(true);
        this.glZ.setDefaultBgResource(R.color.transparent);
        this.glZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hFK.setDefaultBgResource(R.color.transparent);
        this.hFK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setViewTextColor(this.mName, R.color.common_color_10310);
        ap.setViewTextColor(this.hFJ, R.color.white_alpha70);
        ap.setViewTextColor(this.hFQ, R.color.CAM_X0109);
        ap.setViewTextColor(this.gQj, R.color.CAM_X0106);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.hFM.setAlpha(0.4f);
            this.del.setBackgroundColor(this.eGu.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.hFM.setAlpha(1.0f);
        this.del.setBackgroundColor(this.eGu.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.hFI != null && list != null) {
            this.hFI.setData(list);
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
                format = String.format(this.eGu.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.eGu.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            aw(currentPortrait, str, format);
            int dimension = (int) this.eGu.getResources().getDimension(R.dimen.ds32);
            if (this.hFS != null && this.hFS.size() > 0) {
                this.hFS.clear();
            }
            if (this.hFN != null) {
                this.hFN.removeAllViews();
                this.hFS = alaUserInfoData.live_mark_info_new;
                if (this.hFS != null) {
                    for (int i = 0; i < this.hFS.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.eGu.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.hFS.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.eGu.getResources().getDimension(R.dimen.ds12);
                        this.hFN.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        aw(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.eGu.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.hFS != null && this.hFS.size() > 0) {
            this.hFS.clear();
        }
        if (this.hFN != null) {
            this.hFN.removeAllViews();
        }
    }

    private void aw(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.glZ.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.mS().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.hFK.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.hFK.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.glZ.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
            this.hFK.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.hFJ.setText(str3);
        } else {
            this.hFJ.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.eGu != null) {
            if (this.hFO == null) {
                this.hFO = new AlaNetRefreshView(this.eGu.getPageActivity());
            }
            this.hFO.setImageResource(i);
            this.hFO.setNetFailTipText(this.eGu.getString(i2));
            this.hFO.onChangeSkinType();
            this.hFO.setIsShowRefreshButton(z);
            if (z) {
                this.hFO.setOnRefreshClickListener(onClickListener);
            }
            this.hFO.attachView(this.hFP);
        }
    }

    public void VB() {
        if (this.hFO != null) {
            this.hFO.dettachView(this.hFP);
        }
    }
}
