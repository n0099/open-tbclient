package com.baidu.tieba.channel.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.channel.data.i;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private ChannelFansActivity eCU;
    private List<i> mData;

    public b(ChannelFansActivity channelFansActivity) {
        this.eCU = channelFansActivity;
    }

    public void setData(List<i> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pw */
    public i getItem(int i) {
        if (this.mData != null) {
            return this.mData.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.eCU.getPageContext().getPageActivity()).inflate(R.layout.channel_fans_list_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.eCV = (HeadImageView) view.findViewById(R.id.avatar);
            aVar2.eCV.setAutoChangeStyle(true);
            aVar2.eCV.setIsRound(true);
            aVar2.eCV.setClickable(false);
            aVar2.eCW = (TextView) view.findViewById(R.id.fans_name);
            aVar2.eCX = (TextView) view.findViewById(R.id.fans_intro);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        i item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getPortrait())) {
                aVar.eCV.setTag(null);
                aVar.eCV.setDefaultResource(R.drawable.img_default_100);
                aVar.eCV.startLoad(item.getPortrait(), 12, false);
                aVar.eCV.invalidate();
            }
            if (!TextUtils.isEmpty(item.getUser_name())) {
                aVar.eCW.setText(item.getUser_name());
            }
            if (!TextUtils.isEmpty(item.getIntro())) {
                aVar.eCX.setText(item.getIntro());
            }
        }
        this.eCU.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eCU.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes6.dex */
    private class a {
        HeadImageView eCV;
        TextView eCW;
        TextView eCX;

        private a() {
        }
    }
}
