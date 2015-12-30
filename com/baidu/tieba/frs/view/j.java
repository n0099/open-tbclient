package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.GoodGridView;
/* loaded from: classes.dex */
public class j {
    private View MA;
    private GoodGridView bot;
    private ImageView bou;

    public j(Context context) {
        this.MA = null;
        this.bot = null;
        this.bou = null;
        this.MA = LayoutInflater.from(context).inflate(n.h.dialog_good, (ViewGroup) null);
        this.bot = (GoodGridView) this.MA.findViewById(n.g.good_gridview);
        this.bou = (ImageView) this.MA.findViewById(n.g.divider_line);
    }

    public void a(cd cdVar) {
        this.bot.setAdapter((ListAdapter) cdVar);
    }

    public void b(AdapterView.OnItemClickListener onItemClickListener) {
        this.bot.setOnItemClickListener(onItemClickListener);
    }

    public View getView() {
        return this.MA;
    }

    public void changeSkinType(int i) {
        as.j(this.bot, n.d.cp_bg_line_d);
        as.i(this.bou, n.d.frs_goodheader_line_end);
    }
}
