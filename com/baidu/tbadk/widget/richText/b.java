package com.baidu.tbadk.widget.richText;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b {
    private String text;
    public int textColor = TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha100);
    public int bgColor = R.color.cp_link_tip_d;
    public int radius = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds5);
    public int height = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    public int padding = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds11);
    public int leftMargin = 0;
    public int rightMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
    public int offset = 0;
    public int textSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds26);

    public b(String str) {
        this.text = str;
    }

    public String getText() {
        return this.text;
    }
}
