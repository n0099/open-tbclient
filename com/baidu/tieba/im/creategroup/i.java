package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class i implements o {
    HeadImageView hqM;
    ImageView hqN;
    TextView hqO;
    private com.baidu.adp.widget.ImageView.a hqP = null;
    private a hqQ = null;
    CreateGroupStepActivity hqm;
    private int hqq;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hqm = null;
        this.mView = null;
        this.hqM = null;
        this.hqN = null;
        this.hqO = null;
        this.hqm = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.hqN = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.hqM = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.hqO = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.hqq = i3;
    }

    public void bQw() {
        if (this.hqQ != null) {
            this.hqQ.cancel();
        }
        this.hqP = null;
        this.hqQ = new a();
        this.hqQ.execute(new Object[0]);
    }

    public ImageView bQx() {
        return this.hqN;
    }

    public TextView bQy() {
        return this.hqO;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bQg() {
        this.hqN.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bQh() {
        this.hqm.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hqm.getLayoutMode().onModeChanged(this.mView);
        this.hqM.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.m.getImage(null, TbConfig.GROUP_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (bitmap != null) {
                i.this.hqM.setVisibility(0);
                i.this.hqP = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.hqP.drawImageTo(i.this.hqM);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.hqm.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bQj() {
        if (this.mIndex != this.hqq) {
            return this.hqm.getPageContext().getString(R.string.next_step);
        }
        return this.hqm.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bQk() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bQa() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bQl() {
        return true;
    }
}
