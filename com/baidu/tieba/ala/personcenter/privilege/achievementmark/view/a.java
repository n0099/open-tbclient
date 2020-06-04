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
    private TbPageContext<BaseFragmentActivity> dIF;
    private View djM;
    private TextView fEV;
    private HeadImageView ffg;
    private BdListView gqH;
    private b gqI;
    private TextView gqJ;
    private TbImageView gqK;
    private RelativeLayout gqL;
    private ImageView gqM;
    private LinearLayout gqN;
    private AlaNetRefreshView gqO;
    private RelativeLayout gqP;
    private TextView gqQ;
    private InterfaceC0587a gqR;
    private List<AlaLiveMarkData> gqS = new ArrayList();
    private b.a gqT = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.gqR != null) {
                a.this.gqR.a(bVar);
            }
        }
    };
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0587a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0587a interfaceC0587a) {
        this.dIF = tbPageContext;
        this.gqR = interfaceC0587a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.dIF.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.ffg = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.gqJ = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.gqK = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.gqP = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.gqN = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.gqQ = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.gqM = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.fEV = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.djM = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.gqH = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.gqI = new b(this.dIF, this.gqT);
        this.gqH.setAdapter((ListAdapter) this.gqI);
        this.gqL = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.gqH.setEmptyView(this.gqL);
        this.ffg.setIsRound(true);
        this.ffg.setDefaultBgResource(R.color.transparent);
        this.ffg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gqK.setDefaultBgResource(R.color.transparent);
        this.gqK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mName, (int) R.color.common_color_10310);
        am.setViewTextColor(this.gqJ, (int) R.color.white_alpha70);
        am.setViewTextColor(this.gqQ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fEV, (int) R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.gqM.setAlpha(0.4f);
            this.djM.setBackgroundColor(this.dIF.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.gqM.setAlpha(1.0f);
        this.djM.setBackgroundColor(this.dIF.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.gqI != null && list != null) {
            this.gqI.setData(list);
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
                format = String.format(this.dIF.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.dIF.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            ak(currentPortrait, str, format);
            int dimension = (int) this.dIF.getResources().getDimension(R.dimen.ds32);
            if (this.gqS != null && this.gqS.size() > 0) {
                this.gqS.clear();
            }
            if (this.gqN != null) {
                this.gqN.removeAllViews();
                this.gqS = alaUserInfoData.live_mark_info_new;
                if (this.gqS != null) {
                    for (int i = 0; i < this.gqS.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.dIF.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.gqS.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.dIF.getResources().getDimension(R.dimen.ds12);
                        this.gqN.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        ak(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.dIF.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.gqS != null && this.gqS.size() > 0) {
            this.gqS.clear();
        }
        if (this.gqN != null) {
            this.gqN.removeAllViews();
        }
    }

    private void ak(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.ffg.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.kX().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.gqK.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.gqK.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.ffg.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.gqK.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.gqJ.setText(str3);
        } else {
            this.gqJ.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.dIF != null) {
            if (this.gqO == null) {
                this.gqO = new AlaNetRefreshView(this.dIF.getPageActivity());
            }
            this.gqO.setImageResource(i);
            this.gqO.setNetFailTipText(this.dIF.getString(i2));
            this.gqO.onChangeSkinType();
            this.gqO.setIsShowRefreshButton(z);
            if (z) {
                this.gqO.setOnRefreshClickListener(onClickListener);
            }
            this.gqO.attachView(this.gqP);
        }
    }

    public void bqQ() {
        if (this.gqO != null) {
            this.gqO.dettachView(this.gqP);
        }
    }
}
