package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class OfficialBarFeedMsglistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> ajz = new ArrayList<>();
    private c kuq;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes7.dex */
    public interface c {
        void a(View view, Object obj, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfficialBarFeedMsglistAdapter(TbPageContext<?> tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.kuq = cVar;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.ajz.clear();
            this.ajz.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.ajz != null && this.ajz.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.ajz.get(i);
            if ((viewHolder instanceof b) && (aVar instanceof a)) {
                ((b) viewHolder).b(aVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ajz == null) {
            return 0;
        }
        return this.ajz.size();
    }

    /* loaded from: classes7.dex */
    class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView jIr;
        private BarImageView kus;
        private View kut;
        private a kuu;

        b(View view) {
            super(view);
            this.kus = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.jIr = (TextView) view.findViewById(R.id.official_bar_name);
            this.kut = view.findViewById(R.id.official_bar_feed_red_dot);
            this.kus.setShowOval(true);
            this.kus.setPlaceHolder(2);
            this.kus.setShowOuterBorder(false);
            this.kus.setShowInnerBorder(true);
            this.kus.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        void b(com.baidu.tbadk.mvc.b.a aVar) {
            this.kuu = (a) aVar;
            ao.setViewTextColor(this.jIr, R.color.CAM_X0105);
            ao.setBackgroundResource(this.kut, R.drawable.icon_official_bar_red_dot);
            this.kus.setStrokeColorResId(R.color.CAM_X0401);
            this.kus.startLoad(this.kuu.cST(), 10, false);
            if (at.getChineseAndEnglishLength(this.kuu.cNk()) <= 10) {
                this.jIr.setText(this.kuu.cNk());
            } else {
                this.jIr.setText(at.cutChineseAndEnglishWithSuffix(this.kuu.cNk(), 8, StringHelper.STRING_MORE));
            }
            this.kus.setOnClickListener(this);
            if (this.kuu.getUnReadCount() > 0 && (this.kuu.cSU() <= 0 || System.currentTimeMillis() - this.kuu.cSU() < 864000000)) {
                this.kut.setVisibility(0);
            } else {
                this.kut.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.kut.setVisibility(8);
            if (OfficialBarFeedMsglistAdapter.this.kuq != null) {
                OfficialBarFeedMsglistAdapter.this.kuq.a(view, this.kuu, getAdapterPosition(), getItemId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a implements com.baidu.tbadk.mvc.b.a {
        private long cWT;
        private long groupId;
        private String jUh;
        private String kur;
        private int unReadCount;
        private int userType;

        String cST() {
            return this.kur;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String cNk() {
            return this.jUh;
        }

        int getUnReadCount() {
            return this.unReadCount;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void LE(String str) {
            this.kur = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void LF(String str) {
            this.jUh = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setUnReadCount(int i) {
            this.unReadCount = i;
        }

        public void setGroupId(long j) {
            this.groupId = j;
        }

        public void setUserType(int i) {
            this.userType = i;
        }

        public long getGroupId() {
            return this.groupId;
        }

        public long cSU() {
            return this.cWT;
        }

        public void gK(long j) {
            this.cWT = j;
        }
    }
}
