package com.baidu.tieba.ala.personcenter.privilege.achievementmark.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.e.d;
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
/* loaded from: classes10.dex */
public class a {
    private View dnE;
    private TbPageContext<BaseFragmentActivity> eUY;
    private HeadImageView gDB;
    private TextView hlk;
    private BdListView ibM;
    private b ibN;
    private TextView ibO;
    private TbImageView ibP;
    private RelativeLayout ibQ;
    private ImageView ibR;
    private LinearLayout ibS;
    private AlaNetRefreshView ibT;
    private RelativeLayout ibU;
    private TextView ibV;
    private InterfaceC0689a ibW;
    private List<AlaLiveMarkData> ibX = new ArrayList();
    private b.a ibY = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.ibW != null) {
                a.this.ibW.a(bVar);
            }
        }
    };
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0689a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0689a interfaceC0689a) {
        this.eUY = tbPageContext;
        this.ibW = interfaceC0689a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.eUY.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.gDB = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.ibO = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.ibP = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.ibU = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.ibS = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.ibV = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.ibR = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.hlk = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.dnE = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.ibM = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.ibN = new b(this.eUY, this.ibY);
        this.ibM.setAdapter((ListAdapter) this.ibN);
        this.ibQ = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.ibM.setEmptyView(this.ibQ);
        this.gDB.setIsRound(true);
        this.gDB.setDefaultBgResource(R.color.transparent);
        this.gDB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ibP.setDefaultBgResource(R.color.transparent);
        this.ibP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setViewTextColor(this.mName, R.color.common_color_10310);
        ap.setViewTextColor(this.ibO, R.color.white_alpha70);
        ap.setViewTextColor(this.ibV, R.color.CAM_X0109);
        ap.setViewTextColor(this.hlk, R.color.CAM_X0106);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.ibR.setAlpha(0.4f);
            this.dnE.setBackgroundColor(this.eUY.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.ibR.setAlpha(1.0f);
        this.dnE.setBackgroundColor(this.eUY.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.ibN != null && list != null) {
            this.ibN.setData(list);
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
                format = String.format(this.eUY.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.eUY.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            aB(currentPortrait, str, format);
            int dimension = (int) this.eUY.getResources().getDimension(R.dimen.ds32);
            if (this.ibX != null && this.ibX.size() > 0) {
                this.ibX.clear();
            }
            if (this.ibS != null) {
                this.ibS.removeAllViews();
                this.ibX = alaUserInfoData.live_mark_info_new;
                if (this.ibX != null) {
                    for (int i = 0; i < this.ibX.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.eUY.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.ibX.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.eUY.getResources().getDimension(R.dimen.ds12);
                        this.ibS.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        aB(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.eUY.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.ibX != null && this.ibX.size() > 0) {
            this.ibX.clear();
        }
        if (this.ibS != null) {
            this.ibS.removeAllViews();
        }
    }

    private void aB(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.gDB.startLoad(str, 25, false);
            d.mw().a(str, 25, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.ibP.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.ibP.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.gDB.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
            this.ibP.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.ibO.setText(str3);
        } else {
            this.ibO.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.eUY != null) {
            if (this.ibT == null) {
                this.ibT = new AlaNetRefreshView(this.eUY.getPageActivity());
            }
            this.ibT.setImageResource(i);
            this.ibT.setNetFailTipText(this.eUY.getString(i2));
            this.ibT.onChangeSkinType();
            this.ibT.setIsShowRefreshButton(z);
            if (z) {
                this.ibT.setOnRefreshClickListener(onClickListener);
            }
            this.ibT.attachView(this.ibU);
        }
    }

    public void WZ() {
        if (this.ibT != null) {
            this.ibT.dettachView(this.ibU);
        }
    }
}
