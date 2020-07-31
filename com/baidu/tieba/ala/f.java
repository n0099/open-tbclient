package com.baidu.tieba.ala;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.c.l;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.data.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f extends BaseAdapter {
    private ArrayList<m> dWx = new ArrayList<>();
    private TbPageContext mPageContext;

    public f(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setData(List<m> list) {
        if (list != null) {
            this.dWx.clear();
            this.dWx.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dWx.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.dWx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return ((m) getItem(i)).bzR();
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        b bVar = null;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            switch (itemViewType) {
                case 0:
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_wish_list_empty_item_layout, (ViewGroup) null);
                    a aVar2 = new a(view);
                    view.setTag(aVar2);
                    aVar = aVar2;
                    break;
                case 1:
                    view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_wish_list_item_layout, (ViewGroup) null);
                    b bVar2 = new b(view);
                    view.setTag(bVar2);
                    aVar = null;
                    bVar = bVar2;
                    break;
                default:
                    aVar = null;
                    break;
            }
        } else {
            switch (itemViewType) {
                case 0:
                    aVar = (a) view.getTag();
                    break;
                case 1:
                    aVar = null;
                    bVar = (b) view.getTag();
                    break;
                default:
                    aVar = null;
                    break;
            }
        }
        final m mVar = (m) getItem(i);
        if (mVar != null) {
            switch (mVar.bzR()) {
                case 0:
                    if (aVar != null && aVar.rootView != null) {
                        aVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.f.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new l(f.this.mPageContext.getPageActivity(), 1002, f.this.getCount())));
                            }
                        });
                        break;
                    }
                    break;
                case 1:
                    if (bVar != null) {
                        bVar.aKY.setText(mVar.getmName());
                        bVar.flB.setText(mVar.bzS() + "个");
                        bVar.flC.setText(mVar.bzU() + "小时");
                        String string = this.mPageContext.getResources().getString(a.i.add_wish_thank_way_txt);
                        if (!TextUtils.isEmpty(mVar.bzV())) {
                            string = mVar.bzV();
                        }
                        bVar.flD.setText(string);
                        bVar.flE.startLoad(mVar.bzT(), 10, false);
                        if (mVar.bzR() == 1) {
                            if (getItemId(i) == 0) {
                                bVar.flG.setImageResource(a.f.ala_wish_list_item_num_icon_no1);
                            } else if (getItemId(i) == 1) {
                                bVar.flG.setImageResource(a.f.ala_wish_list_item_num_icon_no2);
                            } else if (getItemId(i) == 2) {
                                bVar.flG.setImageResource(a.f.ala_wish_list_item_num_icon_no3);
                            }
                        }
                        if (bVar != null && bVar.rootView != null) {
                            bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.f.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                }
                            });
                        }
                        bVar.flF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.f.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.e(f.this.mPageContext.getPageActivity(), mVar.bzW(), 1001, f.this.getItemId(i))));
                            }
                        });
                        break;
                    }
                    break;
            }
        }
        return view;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public View rootView;

        public a(View view) {
            this.rootView = view;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public TextView aKY;
        public TextView flB;
        public TextView flC;
        public TextView flD;
        public TbImageView flE;
        public TbImageView flF;
        public TbImageView flG;
        public View rootView;

        public b(View view) {
            this.rootView = view;
            this.aKY = (TextView) view.findViewById(a.g.ala_wish_list_item_center_content_first_name);
            this.flB = (TextView) view.findViewById(a.g.ala_wish_list_item_center_content_first_num);
            this.flC = (TextView) view.findViewById(a.g.ala_wish_list_item_center_content_deadline_num);
            this.flD = (TextView) view.findViewById(a.g.ala_wish_list_item_center_content_thank_way);
            this.flE = (TbImageView) view.findViewById(a.g.ala_wish_list_item_icon);
            this.flE.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.flF = (TbImageView) view.findViewById(a.g.ala_wish_list_item_top_delete);
            this.flG = (TbImageView) view.findViewById(a.g.ala_wish_list_item_num_icon);
        }
    }
}
