package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import java.util.ArrayList;
import tbclient.HotUserRankEntry;
import tbclient.ShortUserInfo;
/* loaded from: classes9.dex */
public class HotRankEntryView extends RelativeLayout {
    private boolean hIi;
    private ImageView ifQ;
    private ImageOverlayView ifR;
    private TextView ifS;
    private ImageView mArrow;
    private int mSkinType;

    public HotRankEntryView(Context context) {
        this(context, null);
    }

    public HotRankEntryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        init(context);
    }

    private void init(final Context context) {
        LayoutInflater.from(context).inflate(R.layout.hot_rank_entry, (ViewGroup) this, true);
        this.ifQ = (ImageView) findViewById(R.id.first_tag);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds20);
        this.ifR = (ImageOverlayView) findViewById(R.id.image_group);
        this.ifR.k(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.cp_mask_c_alpha50, dimensionPixelOffset3);
        this.ifR.setStrokeStyle(1);
        this.ifR.setLoadImageType(12);
        this.ifS = (TextView) findViewById(R.id.entry_describe);
        this.mArrow = (ImageView) findViewById(R.id.arrow);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.HotRankEntryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotUserRankActivityConfig(context)));
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(HotUserRankEntry hotUserRankEntry, boolean z) {
        if (hotUserRankEntry != null && hotUserRankEntry.hot_user != null && hotUserRankEntry.hot_user.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (ShortUserInfo shortUserInfo : hotUserRankEntry.hot_user) {
                if (shortUserInfo != null) {
                    arrayList.add(shortUserInfo.portrait);
                }
            }
            this.ifR.setData(arrayList);
            this.hIi = z;
            this.ifS.setText(!ar.isEmpty(hotUserRankEntry.module_name) ? hotUserRankEntry.module_name : getResources().getString(R.string.hot_rank));
            an.setBackgroundResource(this, z ? R.drawable.frs_red_list_entrance_bg_black : R.drawable.frs_red_list_entrance_bg_white);
        }
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            an.setBackgroundResource(this, this.hIi ? R.drawable.frs_red_list_entrance_bg_black : R.drawable.frs_red_list_entrance_bg_white);
            SvgManager.aWQ().a(this.ifQ, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            this.ifR.onChangeSkinType();
            an.setViewTextColor(this.ifS, (int) R.color.cp_cont_a);
            SvgManager.aWQ().a(this.mArrow, R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
