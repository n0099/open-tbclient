package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class c extends l {
    private EditText duw;

    public c(Context context) {
        super(context, (String) null, 29);
        this.dtl = false;
        this.dtk = 3;
        this.dss = new TopicDetaiInputContainer(context);
        this.duw = ((TopicDetaiInputContainer) this.dss).getInputView();
        ((TopicDetaiInputContainer) this.dss).setHint(context.getString(R.string.say_your_point));
        this.dtm = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.duw;
    }
}
