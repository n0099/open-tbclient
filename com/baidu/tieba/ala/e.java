package com.baidu.tieba.ala;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.c.j;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.data.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends BaseAdapter {
    private ArrayList<l> cRO = new ArrayList<>();
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setData(List<l> list) {
        if (list != null && this.cRO.size() < 4) {
            this.cRO.clear();
            this.cRO.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cRO.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.cRO.get(i);
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
        return ((l) getItem(i)).bca();
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
        final l lVar = (l) getItem(i);
        if (lVar != null) {
            switch (lVar.bca()) {
                case 0:
                    if (aVar != null && aVar.rootView != null) {
                        aVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.e.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new j(e.this.mPageContext.getPageActivity(), 1002, e.this.getCount())));
                            }
                        });
                        break;
                    }
                    break;
                case 1:
                    if (bVar != null) {
                        bVar.agP.setText(lVar.getmName());
                        bVar.eff.setText(lVar.bcb() + "个");
                        bVar.efg.setText(lVar.bcd() + "小时");
                        String string = this.mPageContext.getResources().getString(a.i.add_wish_thank_way_txt);
                        if (!TextUtils.isEmpty(lVar.bce())) {
                            string = lVar.bce();
                        }
                        bVar.efh.setText(string);
                        bVar.efi.startLoad(lVar.bcc(), 10, false);
                        if (lVar.bca() == 1) {
                            if (getItemId(i) == 0) {
                                bVar.efk.setImageResource(a.f.ala_wish_list_item_num_icon_no1);
                            } else if (getItemId(i) == 1) {
                                bVar.efk.setImageResource(a.f.ala_wish_list_item_num_icon_no2);
                            } else if (getItemId(i) == 2) {
                                bVar.efk.setImageResource(a.f.ala_wish_list_item_num_icon_no3);
                            }
                        }
                        if (bVar != null && bVar.rootView != null) {
                            bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.e.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                }
                            });
                        }
                        bVar.efj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.e.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.d(e.this.mPageContext.getPageActivity(), lVar.bcf(), 1001, e.this.getItemId(i))));
                            }
                        });
                        break;
                    }
                    break;
            }
        }
        return view;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public View rootView;

        public a(View view) {
            this.rootView = view;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public TextView agP;
        public TextView eff;
        public TextView efg;
        public TextView efh;
        public TbImageView efi;
        public TbImageView efj;
        public TbImageView efk;
        public View rootView;

        public b(View view) {
            this.rootView = view;
            this.agP = (TextView) view.findViewById(a.g.ala_wish_list_item_center_content_first_name);
            this.eff = (TextView) view.findViewById(a.g.ala_wish_list_item_center_content_first_num);
            this.efg = (TextView) view.findViewById(a.g.ala_wish_list_item_center_content_deadline_num);
            this.efh = (TextView) view.findViewById(a.g.ala_wish_list_item_center_content_thank_way);
            this.efi = (TbImageView) view.findViewById(a.g.ala_wish_list_item_icon);
            this.efj = (TbImageView) view.findViewById(a.g.ala_wish_list_item_top_delete);
            this.efk = (TbImageView) view.findViewById(a.g.ala_wish_list_item_num_icon);
        }
    }
}
