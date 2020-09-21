package com.baidu.tieba.ala;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.b.l;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.data.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g extends BaseAdapter {
    private ArrayList<m> eiq = new ArrayList<>();
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setData(List<m> list) {
        if (list != null) {
            this.eiq.clear();
            this.eiq.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eiq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eiq.get(i);
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
        return ((m) getItem(i)).bKe();
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
            switch (mVar.bKe()) {
                case 0:
                    if (aVar != null && aVar.rootView != null) {
                        aVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.g.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new l(g.this.mPageContext.getPageActivity(), 1002, g.this.getCount())));
                            }
                        });
                        break;
                    }
                    break;
                case 1:
                    if (bVar != null) {
                        bVar.aSp.setText(mVar.getmName());
                        bVar.fAn.setText(mVar.bKf() + "个");
                        bVar.fAo.setText(mVar.bKh() + "小时");
                        String string = this.mPageContext.getResources().getString(a.i.add_wish_thank_way_txt);
                        if (!TextUtils.isEmpty(mVar.bKi())) {
                            string = mVar.bKi();
                        }
                        bVar.fAp.setText(string);
                        bVar.fAq.startLoad(mVar.bKg(), 10, false);
                        if (mVar.bKe() == 1) {
                            if (getItemId(i) == 0) {
                                bVar.fAs.setImageResource(a.f.ala_wish_list_item_num_icon_no1);
                            } else if (getItemId(i) == 1) {
                                bVar.fAs.setImageResource(a.f.ala_wish_list_item_num_icon_no2);
                            } else if (getItemId(i) == 2) {
                                bVar.fAs.setImageResource(a.f.ala_wish_list_item_num_icon_no3);
                            }
                        }
                        if (bVar != null && bVar.rootView != null) {
                            bVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.g.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                }
                            });
                        }
                        bVar.fAr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.g.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.e(g.this.mPageContext.getPageActivity(), mVar.bKj(), 1001, g.this.getItemId(i))));
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
        public TextView aSp;
        public TextView fAn;
        public TextView fAo;
        public TextView fAp;
        public TbImageView fAq;
        public TbImageView fAr;
        public TbImageView fAs;
        public View rootView;

        public b(View view) {
            this.rootView = view;
            this.aSp = (TextView) view.findViewById(a.g.ala_wish_list_item_center_content_first_name);
            this.fAn = (TextView) view.findViewById(a.g.ala_wish_list_item_center_content_first_num);
            this.fAo = (TextView) view.findViewById(a.g.ala_wish_list_item_center_content_deadline_num);
            this.fAp = (TextView) view.findViewById(a.g.ala_wish_list_item_center_content_thank_way);
            this.fAq = (TbImageView) view.findViewById(a.g.ala_wish_list_item_icon);
            this.fAq.setDefaultBgResource(a.f.sdk_shape_transparent);
            this.fAr = (TbImageView) view.findViewById(a.g.ala_wish_list_item_top_delete);
            this.fAs = (TbImageView) view.findViewById(a.g.ala_wish_list_item_num_icon);
        }
    }
}
